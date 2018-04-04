package com.yuhong.hong.entity

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * Created by zhang_shuai on 2018/3/13
 *
 * Del:导航栏的实体类
 */
class TabEntity : CustomTabEntity {

    var title : String = ""
    var selectedIcon : Int = 0
    var unSelectedIcon : Int = 0


    constructor(title: String, selectedIcon: Int, unSelectedIcon: Int) {
        this.title = title
        this.selectedIcon = selectedIcon
        this.unSelectedIcon = unSelectedIcon
    }

    constructor()

    constructor(title: String) {
        this.title = title
    }


    override fun getTabUnselectedIcon(): Int {
        return unSelectedIcon
    }

    override fun getTabSelectedIcon(): Int {
        return selectedIcon
    }

    override fun getTabTitle(): String {
        return title
    }


}