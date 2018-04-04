package com.yuhong.hong.adapter

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.yuhong.hong.R
import com.yuhong.hong.entity.MsgEntity
import com.yuhong.hong.interfaces.onRecyclerViewItemClickListener

/**
 * Created by zhang_shuai on 2018/3/15
 *
 * Del:
 */
class AddressRecyclerAdapter : RecyclerView.Adapter<AddressRecyclerAdapter.ViewHodler> {

    private var mData: MutableList<MsgEntity>? = null
    var mSpaceItemDecoration: SpaceItemDecoration? = null
    //监听事件
    var itemClickListener: onRecyclerViewItemClickListener? = null
    private var contxt: Context? = null;


    constructor(mData: MutableList<MsgEntity>?, mSpace: Int, context: Activity?, item: onRecyclerViewItemClickListener) : super() {
        this.mData = mData
        this.contxt = contxt
        this.itemClickListener = item

        notifyDataSetChanged()

        mSpaceItemDecoration = SpaceItemDecoration(mSpace = mSpace)


    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHodler {
        var view: View = View.inflate(parent?.context, R.layout.address_rceycler_item, null)

        //为itemView绑定点击事件
        view.setOnClickListener {
            if (itemClickListener != null) {
                itemClickListener!!.onItemClick(view, view.tag as Int)
                Log.e("111", "onItemClick=====" + view.tag)
            }
        }
        return ViewHodler(view)
    }

    override fun onBindViewHolder(holder: ViewHodler?, position: Int) {
        holder?.ico_iv!!.setImageResource(mData!![position].ico)
        holder?.msg_tv!!.text = mData!![position].msg
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return mData!!.size
    }

    class ViewHodler : RecyclerView.ViewHolder {
        var msg_tv: TextView
        var ico_iv: ImageView

        constructor(view: View) : super(view) {
            msg_tv = view.findViewById(R.id.address_tv) as TextView
            ico_iv = view.findViewById(R.id.address_iv) as ImageView

        }


    }

    /**
     * 设置item间距
     */
    class SpaceItemDecoration : RecyclerView.ItemDecoration {
        private var mSpace = 0

        constructor(mSpace: Int) : super() {
            this.mSpace = mSpace

        }

        override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
            super.getItemOffsets(outRect, view, parent, state)
            outRect!!.left = mSpace;
            outRect!!.right = mSpace;
            outRect!!.bottom = mSpace;
            outRect!!.top = mSpace;

        }

    }

}






