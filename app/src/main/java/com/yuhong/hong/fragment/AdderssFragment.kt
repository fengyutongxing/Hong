package com.yuhong.hong.fragment

import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.flyco.tablayout.SlidingTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.yuhong.hong.R
import com.yuhong.hong.adapter.AddressRecyclerAdapter
import com.yuhong.hong.adapter.MyPagerAdapter
import com.yuhong.hong.base.BaseFragment
import com.yuhong.hong.custom.CommonTitle
import com.yuhong.hong.entity.MsgEntity
import com.yuhong.hong.entity.TabEntity
import com.yuhong.hong.interfaces.onRecyclerViewItemClickListener

/**
 * Created by zhang_shuai on 2018/3/15
 *
 * Del:主通讯录
 */
class AdderssFragment : BaseFragment(),OnTabSelectListener,View.OnClickListener {


    private var mBar: CommonTitle? = null
    private var mRceyclerView: RecyclerView? = null
    private var mData: MutableList<MsgEntity> = ArrayList()

    private var mSlidingTab: SlidingTabLayout? = null     //中间的tab
    private var mViewPager: ViewPager? = null

    private var mTitles: Array<String> = arrayOf("我的同事", "常用联系人", "我的名片")  //小标题
    private var mFragments: MutableList<Fragment> = ArrayList()
    private var mTabEntities: MutableList<CustomTabEntity> = ArrayList()

    override fun getLayoutId(): Int {
        return R.layout.fragment_address
    }

    override fun onInitView(rootView: View) {
        mBar = rootView.findViewById(R.id.title_Bar)
        mRceyclerView = rootView.findViewById(R.id.address_recyc)
        mSlidingTab =  rootView.findViewById(R.id.address_slidingTab)
        mViewPager = rootView.findViewById(R.id.address_viewPager)
    }

    override fun onInitData() {
        mBar!!.tv_title!!.text = "通讯录"
        mBar!!.iv_left!!.setImageResource(R.drawable.sync)
        mBar!!.iv_right!!.setImageResource(R.mipmap.icon_search_red)

        mBar!!.iv_left!!.setOnClickListener(this)
        mBar!!.iv_right!!.setOnClickListener(this)

        mData!!.add(MsgEntity(R.drawable.group,"群组"))
        mData!!.add(MsgEntity(R.drawable.organization,"组织架构"))
        mData!!.add(MsgEntity(R.drawable.mpublic,"公告名录"))
        mData!!.add(MsgEntity(R.drawable.follow,"关注"))

        mFragments!!.add(AddressFellowFragment())
        mFragments!!.add(AddressContactsFragment())
        mFragments!!.add(AddressCardFragment())

        mRceyclerView!!.layoutManager = GridLayoutManager(activity,4)
        var adapter = AddressRecyclerAdapter(mData,30, activity,itemClick())
        mRceyclerView!!.addItemDecoration(adapter.mSpaceItemDecoration)
        mRceyclerView!!.adapter = adapter

        //根据下标获得值
        for ((index, value)  in mTitles.withIndex()) {
            mTabEntities.add(TabEntity(mTitles[index]))
        }

        mViewPager!!.adapter =  MyPagerAdapter(childFragmentManager,mTitles,mFragments)
        mViewPager!!.offscreenPageLimit = 3
        mSlidingTab!!.setOnTabSelectListener(this)
        mSlidingTab!!.setViewPager(mViewPager)

    }


    inner class itemClick: onRecyclerViewItemClickListener {

        override fun onItemClick(v: View, position: Int) {
            Toast.makeText(activity,"你点击了第"+(position+1)+"个", Toast.LENGTH_LONG).show()
        }
    }

    override fun onTabSelect(position: Int) {
        mViewPager!!.currentItem = position
    }

    override fun onTabReselect(position: Int) {
        if (position == 0) {
//            mTab.showMsg(0, mRandom.nextInt(100) + 1)
//                    UnreadMsgUtils.show(mTabLayout_2.getMsgView(0), 1)
        }
    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.iv_left ->{
                Toast.makeText(activity,"网盘同步", Toast.LENGTH_LONG).show()

            }
            R.id.iv_right ->{
                Toast.makeText(activity,"搜索功能", Toast.LENGTH_LONG).show()

            }
        }
    }


}