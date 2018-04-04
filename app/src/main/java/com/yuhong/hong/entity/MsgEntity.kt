package com.yuhong.hong.entity

/**
 * Created by zhang_shuai on 2018/3/15
 *
 * Del:信息列表的实体类
 */
class MsgEntity {

     var ico: Int = 0
     var msg: String = ""
     var arrow: Int = 0

    constructor(ico: Int, msg: String, arrow: Int) {
        this.ico = ico
        this.msg = msg
        this.arrow = arrow
    }

    constructor(ico: Int, msg: String) {
        this.ico = ico
        this.msg = msg
    }

    constructor(msg: String) {
        this.msg = msg
    }

    constructor(ico: Int) {
        this.ico = ico
    }


}