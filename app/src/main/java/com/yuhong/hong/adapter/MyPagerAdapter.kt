package com.yuhong.hong.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * Created by zhang_shuai on 2018/3/13
 *
 * Del:
 */
class MyPagerAdapter : FragmentPagerAdapter{

    var mTitles: Array<String>? = null
    var mFragments: MutableList<Fragment>? = null

    constructor(fm: FragmentManager?, mTitles: Array<String>?, mFragments: MutableList<Fragment>) : super(fm) {
        this.mTitles = mTitles
        this.mFragments = mFragments
    }

    override fun getItem(position: Int): Fragment {
        return mFragments!!.get(position)
    }

    override fun getCount(): Int {
        return mTitles!!.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles!!.get(position)

    }
}