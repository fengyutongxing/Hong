package com.yuhong.hong.fragment

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.yuhong.hong.R
import com.yuhong.hong.adapter.RecyclerViewAdapter
import com.yuhong.hong.base.BaseFragment
import com.yuhong.hong.custom.CommonTitle
import com.yuhong.hong.entity.MsgEntity
import com.yuhong.hong.interfaces.onRecyclerViewItemClickListener

/**
 * Created by zhang_shuai on 2018/3/15
 *
 * Del:
 */
class MyFragment : BaseFragment() {

    private var mBar: CommonTitle? = null
    private var mRceycler: RecyclerView? = null
    private var mRecyclerView: RecyclerView? = null

    //两个数据源
    private var mData: MutableList<MsgEntity> = mutableListOf()
    private var mDatas: MutableList<MsgEntity> = mutableListOf()


    override fun getLayoutId(): Int {
        return R.layout.fragment_my
    }

    override fun onInitView(rootView: View) {
        mBar = rootView.findViewById(R.id.title_Bar)
        mRceycler = rootView.findViewById(R.id.my_recycl1)
        mRecyclerView = rootView.findViewById(R.id.my_recycl2)

    }

    override fun onInitData() {
        mBar!!.tv_title!!.text = "我的"

        mData!!.add(MsgEntity(R.mipmap.card_icon,"微名片",R.mipmap.pt_right))
        mData!!.add(MsgEntity(R.mipmap.worksapce,"工作圈",R.mipmap.pt_right))

        mDatas!!.add(MsgEntity(R.mipmap.advice,"意见反馈",R.mipmap.pt_right))
        mDatas!!.add(MsgEntity(R.mipmap.setting,"设置",R.mipmap.pt_right))

        // 显示第一个数据
        mRceycler!!.layoutManager = LinearLayoutManager(activity)
        var adapter = RecyclerViewAdapter(mData,30, activity,itemClick())
        mRceycler!!.addItemDecoration(adapter.mSpaceItemDecoration)
        mRceycler!!.isNestedScrollingEnabled = false
        mRceycler!!.adapter = adapter

        // 第二个数据展示
        mRecyclerView!!.layoutManager = LinearLayoutManager(activity)
        var adapter2 = RecyclerViewAdapter(mDatas,30, activity,itemClick())
        mRecyclerView!!.addItemDecoration(adapter2.mSpaceItemDecoration)
        mRecyclerView!!.isNestedScrollingEnabled = false
        mRecyclerView!!.adapter = adapter2

    }


    inner class itemClick: onRecyclerViewItemClickListener {

        override fun onItemClick(v: View, position: Int) {
            Toast.makeText(activity,"你点击了第"+(position+1)+"个", Toast.LENGTH_LONG).show()
        }
    }
}