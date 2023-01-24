package com.vshum.lessonstimer.windows.home

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.vshum.lessonstimer.Consts
import com.vshum.lessonstimer.base.BaseFragment
import com.vshum.lessonstimer.data.Classes
import com.vshum.lessonstimer.data.HomeWork
import com.vshum.lessonstimer.data.Tee
import com.vshum.lessonstimer.databinding.FragmentHomeBinding
import com.vshum.lessonstimer.di.Scopes
import org.koin.core.qualifier.named
import org.koin.java.KoinJavaComponent

class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val scope = KoinJavaComponent.getKoin().createScope<HomeFragment>()
    private val viewModel: HomeViewModel = scope.get(qualifier = named(Scopes.HOME_VIEW_MODEL))

    override fun afterOnCreateView() {
        viewModel.getLiveData().observe(viewLifecycleOwner) { renderData(it) }
    }

    override fun onResume() {
        super.onResume()
        //получаем остаточное время до экзамена
        viewModel.getTimeToExam()
        //получаем список уроков
        viewModel.getClasses(requireContext().resources)
        //получаем список домашней работы
        viewModel.getHomeWorks()
    }

    /**
     * Обработать событие от viewModel.
     * @param state полученное состояние.
     */
    private fun renderData(state: HomeState) {
        when(state) {
            //получено время до начала экамена
            is HomeState.TimeToExam -> setTimeToExam(state.time)

            //получен список домашней работы
            is HomeState.HomeWorkList -> setHomeWork(state.homework)

            //получен список уроков
            is HomeState.ClassesList -> setClasses(
                state.classes,
                state.currentClass,
                state.countClasses)
        }
    }

    /** Сформировать список уроков */
    private fun setClasses(classes: List<Classes>, currentClass: Int, countClasses: String) {
        Log.d(Consts.TAG_LOG, "renderData -> setClasses")
        binding?.let {
            it.classesViewPager.adapter = HomeClassesAdapter(classes, object: ClassesAdapterListener {
                override fun buttonZoomClick(zoomUrl: String?) {
                    zoomUrl?.let { url ->
                        val zoom = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                        startActivity(zoom)
                    }
                }
            })
            //выделяем нужный урок
            it.classesViewPager.currentItem = currentClass
            //пишем сколько уроков сегодня или в следующий день
            it.classesCount.text = countClasses
        }
    }

    /**
     * Заполнить остаточное время до экзамена.
     * @param time связка остатка дней, часов и минут
     */
    private fun setTimeToExam(time: Tee<Long, Long, Long>) {
        Log.d(Consts.TAG_LOG, "renderData -> setTimeToExam")
        val day = String.format("%02d", time.first)
        val hour = String.format("%02d", time.second)
        val min = String.format("%02d", time.third)
        binding?.let {
            it.itemTimer.timerDay1.text = day[0].toString()
            it.itemTimer.timerDay2.text = day[1].toString()
            it.itemTimer.timerHour1.text = hour[0].toString()
            it.itemTimer.timerHour2.text = hour[1].toString()
            it.itemTimer.timerMin1.text = min[0].toString()
            it.itemTimer.timerMin2.text = min[1].toString()
        }
    }

    /** Заполнить список домашней работы */
    private fun setHomeWork(homework: List<HomeWork>) {
        Log.d(Consts.TAG_LOG, "renderData -> setHomeWork")
        binding?.let {
            it.homeworkRecyclerview.adapter = HomeWorkAdapter(homework)
            it.homeworkRecyclerview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,  false)
            it.homeworkRecyclerview.itemAnimator = DefaultItemAnimator()
        }
    }
}