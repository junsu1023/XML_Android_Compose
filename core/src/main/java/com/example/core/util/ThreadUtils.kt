package com.example.core.util

import android.os.Looper

val isMainThread get() = Looper.getMainLooper() == Looper.myLooper()