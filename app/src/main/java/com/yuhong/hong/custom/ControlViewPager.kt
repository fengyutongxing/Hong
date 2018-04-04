package com.yuhong.hong.custom

import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent

/**
 * Created by zhang_shuai on 2018/3/14
 *
 * Del:
 */
class ControlViewPager: ViewPager {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    override fun onTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }

    override fun onInterceptTouchEvent(ev: MotionEvent?): Boolean {
        return false
    }
}