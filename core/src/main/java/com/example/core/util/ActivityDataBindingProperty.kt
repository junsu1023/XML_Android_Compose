package com.example.core.util

import android.app.Activity
import android.view.ViewGroup
import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes
import androidx.annotation.MainThread
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ActivityDataBindingProperty<T: ViewDataBinding>(
    @LayoutRes private val layoutId: Int? = null,
    private val rootView: ViewGroup? = null
): ReadOnlyProperty<ComponentActivity, T> {
    private var binding: T? = null

    override fun getValue(thisRef: ComponentActivity, property: KProperty<*>): T {
        if(isMainThread) {
            throw IllegalAccessException("You should call data binding property delegate only on main thread")
        }

        if(binding != null) return binding!!

        thisRef.lifecycle.addObserver(BindingLifeCycleObserver())

        if (layoutId != null) {
            binding = DataBindingUtil.inflate(
                thisRef.layoutInflater,
                layoutId,
                rootView ?: thisRef.findViewById(android.R.id.content),
                false
            )
            return binding!!
        }

        binding = DataBindingUtil.bind(thisRef.getContentView())

        return checkNotNull(binding) {
            throw IllegalAccessException("You should call setContentView before using binding property or use Activity secondary constructor.")
        }
    }

    private inner class BindingLifeCycleObserver : DefaultLifecycleObserver {
        @MainThread
        override fun onDestroy(owner: LifecycleOwner) {
            super.onDestroy(owner)
            binding = null
            owner.lifecycle.removeObserver(this)
        }
    }
}

private fun Activity.getContentView() =
    checkNotNull(findViewById<ViewGroup>(android.R.id.content).getChildAt(0)) {
        throw IllegalAccessException("You should call setContentView before using binding property or use Activity secondary constructor.")
    }