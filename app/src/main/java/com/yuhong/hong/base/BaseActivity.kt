package com.yuhong.hong.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by zhang_shuai on 2018/3/12
 *
 * Del:
 */
abstract class BaseActivity : AppCompatActivity() {

    protected var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = this
        if(0 != getLayoutId()){
            setContentView(getLayoutId())
        }
        initView()
        initData()
    }

    abstract fun getLayoutId():Int
    abstract fun initView()
    abstract fun initData()

}