package com.vshum.lessonstimer.base

import android.view.LayoutInflater
import android.view.ViewGroup

typealias InflateFragment<T> = (LayoutInflater, ViewGroup?, Boolean) -> T