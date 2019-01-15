package com.example.carwashing.util

import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.appcompat.widget.Toolbar

interface HasToolbar {
    val toolbar: Toolbar
    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun enableHomeAsUp(enable: Boolean = true, up: (() -> Unit)? = null) {
        if (enable) {
            toolbar.navigationIcon = createUpDrawable()
            toolbar.setNavigationOnClickListener { up?.invoke() }
        } else {
            toolbar.navigationIcon = null
        }

    }

    private fun createUpDrawable() = with(DrawerArrowDrawable(toolbar.context)) {
        progress = 1f
        this
    }
}