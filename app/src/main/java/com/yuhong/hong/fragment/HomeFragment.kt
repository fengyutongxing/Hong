package com.yuhong.hong.fragment

import android.content.Intent
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import com.yuhong.hong.R
import com.yuhong.hong.base.BaseFragment
import com.yuhong.hong.custom.CommonTitle

/**
 * Created by zhang_shuai on 2018/3/15
 *
 * Del:主界面
 */
class HomeFragment : BaseFragment(), View.OnClickListener {

    private var mBar: CommonTitle? = null
    private var mFab: FloatingActionButton? = null

    private var f: SwitchFragment? = null

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onInitView(rootView: View) {
        mBar = rootView.findViewById(R.id.title_Bar)
        mFab = rootView.findViewById(R.id.home_fab)
        mFab!!.setOnClickListener(this)
    }

    override fun onInitData() {
        mBar!!.tv_title!!.text = "销售"

    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.home_fab -> {

                Toast.makeText(activity, "你点击了", Toast.LENGTH_LONG).show()
//                switchContent(HomeFragment(),SwitchFragment())
                fragmentManager.beginTransaction()
                        .setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out)
                        .replace(R.id.home_fl, SwitchFragment())
                        .addToBackStack(null)
                        .commit()
//                initFragment1()
            }
        }
    }

    private fun initFragment1() {

       var transaction = fragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out)
//        transaction.addToBackStack("SwitchFragment")
//        if(f == null){
            f = SwitchFragment()
//            transaction.add(R.id.home_fl,f)
//        }
        //隐藏所有fragment
//        hideFragment(transaction)

        //显示需要显示的fragment
//        transaction.show(f);
        //提交事务
//        transaction.commit();
    }
//
//    private fun hideFragment(transaction: FragmentTransaction?) {
//
//        if(f != null){
//            transaction!!.hide(f)
//        }
//    }


//    private fun switchContent(from: Fragment, to: Fragment) {
//
//        if (from != to) {
//              var transaction  = activity.supportFragmentManager.beginTransaction()
//
//            //判断是否添加过
//            if (!to!!.isAdded) {
//                // 隐藏当前的fragment，add下一个到Activity中
//                transaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out).hide(from).add(R.id.home_fl,to)
//                        .addToBackStack("SwitchFragment").commit()
//            }else{
//                // 隐藏当前的fragment，显示下一个
//                transaction.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_left_out).hide(from)
//                        .show(to).commit()
//            }
//        }
//
//    }

}

