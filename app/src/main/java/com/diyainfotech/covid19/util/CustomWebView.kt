package com.diyainfotech.covid19.util

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.webkit.WebView

class CustomWebView : WebView {
    constructor(context: Context) : super(context)
    constructor(context: Context,attrs : AttributeSet) : super(context,attrs)
    constructor(context: Context,attrs : AttributeSet,defStyleAttr:Int) : super(context,attrs,defStyleAttr)
    constructor(context: Context,attrs : AttributeSet,defStyleAttr:Int,defStyleRes:Int) : super(context,attrs,defStyleAttr,defStyleRes)
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        requestDisallowInterceptTouchEvent(true)
        return super.onTouchEvent(event)
    }
}