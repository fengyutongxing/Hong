package com.yuhong.hong.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.yuhong.hong.R

/**
 * Created by zhang_shuai on 2018/3/14
 *
 * Del:
 */
class CommonTitle : RelativeLayout {
    public var iv_left: ImageView? = null
    public var iv_right: ImageView? = null
    public var tv_title: TextView? = null
    public var tv_left: TextView? = null
    public var tv_right: TextView? = null

    constructor(context: Context?) : super(context){
        initView(context)
        setOnClickListener{}
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initView(context)
        setOnClickListener{}
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initView(context)
        setOnClickListener{}
    }

    fun initView(context: Context?){
         View.inflate(context, R.layout.common_title,this)
         iv_left = findViewById(R.id.iv_left)
         tv_left = findViewById(R.id.tv_left)
         iv_right= findViewById(R.id.iv_right)
         tv_title = findViewById(R.id.tv_title)
         tv_right = findViewById(R.id.tv_right)
     }
}