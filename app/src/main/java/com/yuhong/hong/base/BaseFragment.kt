package com.yuhong.hong.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by zhang_shuai on 2018/3/14
 *
 * Del:
 */
abstract class BaseFragment : Fragment() {

    private var mInflater: LayoutInflater? = null
    private var rootView: View? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        this.mInflater = inflater
        if(rootView == null){
            rootView = inflateView(getLayoutId())
            onInitView(rootView!!)
        }
        onInitData()
        return rootView

    }

    abstract fun getLayoutId() : Int
    abstract fun onInitView(rootView: View)
    abstract fun onInitData()

    protected fun inflateView(resId: Int?) : View{
        return this.mInflater!!.inflate(resId!!,null)
    }


}