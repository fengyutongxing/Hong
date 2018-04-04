package com.yuhong.hong

import android.support.v4.app.Fragment
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.yuhong.hong.base.BaseActivity
import com.yuhong.hong.entity.TabEntity
import com.yuhong.hong.fragment.*

class MainActivity : BaseActivity() {

    private var mTab: CommonTabLayout? = null
    private var mTitles: Array<String> = arrayOf("消息", "通讯录", "A  I", "日程", "我的")

    private var mIconUnselectIds: Array<Int> = arrayOf(R.mipmap.tab_icon_message_nor, R.mipmap.tab_icon_address_nor,
            R.mipmap.tab_icon_home_nor, R.mipmap.tab_icon_schedule_nor, R.mipmap.tab_icon_me_nor)
    private var mIconSelectIds: Array<Int> = arrayOf(R.mipmap.tab_icon_message_over, R.mipmap.tab_icon_address_over,
            R.mipmap.tab_icon_home_over, R.mipmap.tab_icon_schedule_over, R.mipmap.tab_icon_me_over)

    private var mTabEntities: MutableList<CustomTabEntity> = mutableListOf()
    private var mFragments: MutableList<Fragment> = mutableListOf()

    override fun getLayoutId(): Int {
        return R.layout.activity_main;
    }

    override fun initView() {
        mTab = findViewById(R.id.main_tab) as CommonTabLayout

    }

    override fun initData() {

        //添加fragment
        mFragments.add(MessageFragment())
        mFragments.add(AdderssFragment())
        mFragments.add(HomeFragment())
        mFragments.add(CalendarFragment())
        mFragments.add(MyFragment())

        //根据下标获得值
        for ((index, value) in mTitles.withIndex()) {
            mTabEntities.add(TabEntity(mTitles[index], mIconSelectIds[index], mIconUnselectIds[index]))
        }

        //设置数据
        mTab!!.setTabData(mTabEntities as java.util.ArrayList<CustomTabEntity>?,this,R.id.main_frameLayout, mFragments as java.util.ArrayList<Fragment>?)

        //默认第一次加载页面
        mTab!!.currentTab = 2

    }


}




