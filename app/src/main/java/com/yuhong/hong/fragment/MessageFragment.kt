package com.yuhong.hong.fragment

import android.support.annotation.RequiresApi
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
 * Del: 主消息模块
 */
class MessageFragment: BaseFragment() {

    private var mData: MutableList<MsgEntity> = ArrayList()

    private var msg_rceyclerView: RecyclerView? = null
    private var mBar: CommonTitle? = null


    override fun getLayoutId(): Int {
        return R.layout.fragment_message
    }

    override fun onInitView(rootView: View) {
        msg_rceyclerView = rootView.findViewById(R.id.msg_rceyclerView) as RecyclerView
        mBar = rootView.findViewById(R.id.title_Bar)
    }

    @RequiresApi(26)
    override fun onInitData() {
        mBar!!.tv_title!!.text = "消息"

        mData!!.add(MsgEntity(R.drawable.message,"待办消息",R.mipmap.pt_right))
        mData!!.add(MsgEntity(R.drawable.attention,"集团公告、集团文件",R.mipmap.pt_right))
        mData!!.add(MsgEntity(R.drawable.subscription,"订阅号",R.mipmap.pt_right))
        mData!!.add(MsgEntity(R.drawable.shortmessage,"短消息",R.mipmap.pt_right))

        msg_rceyclerView!!.layoutManager =LinearLayoutManager(activity)
        var adapter = RecyclerViewAdapter(mData,30, activity,itemClick())
        msg_rceyclerView!!.addItemDecoration(adapter.mSpaceItemDecoration)
        msg_rceyclerView!!.isNestedScrollingEnabled = false
        msg_rceyclerView!!.adapter = adapter
    }

    inner class itemClick: onRecyclerViewItemClickListener{

        override fun onItemClick(v: View, position: Int) {
            Toast.makeText(activity,"你点击了第"+(position+1)+"个",Toast.LENGTH_LONG).show()
        }
    }
}