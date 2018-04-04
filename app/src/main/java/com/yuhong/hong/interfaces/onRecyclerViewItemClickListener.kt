package com.yuhong.hong.interfaces

import android.view.View

/**
 * Created by zhang_shuai on 2018/3/19
 *
 * Del:RecyclerView item的接口回调
 */
interface onRecyclerViewItemClickListener {

    fun onItemClick(v: View, position: Int);

}