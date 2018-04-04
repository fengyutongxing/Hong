package com.yuhong.hong.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import com.haibin.calendarview.Calendar
import com.haibin.calendarview.CalendarLayout
import com.haibin.calendarview.CalendarView
import com.yuhong.hong.R
import com.yuhong.hong.base.BaseFragment
import com.yuhong.hong.custom.CommonTitle
import com.yuhong.hong.calendar.Article
import com.yuhong.hong.calendar.ArticleAdapter
import com.yuhong.hong.calendar.GroupItemDecoration
import com.yuhong.hong.calendar.GroupRecyclerView

/**
 * Created by zhang_shuai on 2018/3/15
 *
 * Del:主界面 日历功能
 */
class CalendarFragment : BaseFragment(), View.OnClickListener, CalendarView.OnDateSelectedListener, CalendarView.OnYearChangeListener {


    private var mBar: CommonTitle? = null
    private var mMonth_day: TextView? = null  // 几月几日
    private var mTextYear: TextView? = null       // 年
    private var mLunar: TextView? = null      // 今日 显示阴历

    private var mLocation: RelativeLayout? = null   // 定位当前日期
    private var mCurrent_day: TextView? = null      // 定位今日

    private var mCalendarLayout: CalendarLayout? = null   //日历的收缩控制功能
    private var mCalendarView: CalendarView? = null   //日历
    private var mRecyclerView: GroupRecyclerView? = null    //创建的列表数据

    private var mYear: Int? = 0

    override fun getLayoutId(): Int {
        return R.layout.fragment_calendar
    }

    override fun onInitView(rootView: View) {
        mBar = rootView.findViewById(R.id.title_Bar)
        mMonth_day = rootView.findViewById(R.id.tv_month_day)
        mMonth_day!!.setOnClickListener(this)
        mTextYear = rootView.findViewById(R.id.tv_year)
        mLunar = rootView.findViewById(R.id.tv_lunar)

        mLocation = rootView.findViewById(R.id.fl_current)
        mLocation!!.setOnClickListener(this)
        mCurrent_day = rootView.findViewById(R.id.tv_current_day);

        mCalendarLayout = rootView.findViewById(R.id.calendarLayout)
        mCalendarView = rootView.findViewById(R.id.calendarView)
        mCalendarView!!.setOnDateSelectedListener(this)
        mCalendarView!!.setOnYearChangeListener(this)

        mRecyclerView = rootView.findViewById(R.id.recyclerView)

    }

    override fun onInitData() {
        mBar!!.tv_title!!.text = "日程"
        mBar!!.iv_right!!.setImageResource(R.mipmap.btn_add)
        mBar!!.iv_right!!.setOnClickListener(this)

        mYear = mCalendarView!!.curYear
        mMonth_day!!.text = "" + mCalendarView!!.curMonth + "月" + mCalendarView!!.curDay + "日"
        mLunar!!.text = "今日"
        mCurrent_day!!.text = mCalendarView!!.curDay.toString()
        mTextYear!!.text = mCalendarView!!.curYear.toString()

        //获得年月
        var year = mCalendarView!!.curYear
        var month = mCalendarView!!.curMonth

        var schemes: MutableList<Calendar> = mutableListOf()
        schemes.add(getSchemeCalendar(year, month, 3, 0xFF40db25.toInt(), "假"))
        schemes.add(getSchemeCalendar(year, month, 6, 0xFFe69138.toInt(), "事"))
        schemes.add(getSchemeCalendar(year, month, 10, 0xFFdf1356.toInt(), "议"))
        schemes.add(getSchemeCalendar(year, month, 11, 0xFFedc56d.toInt(), "记"))
        schemes.add(getSchemeCalendar(year, month, 14, 0xFFedc56d.toInt(), "记"))
        schemes.add(getSchemeCalendar(year, month, 18, 0xFFaacc44.toInt(), "假"))
        schemes.add(getSchemeCalendar(year, month, 25, 0xFFe69138.toInt(), "事"))
        schemes.add(getSchemeCalendar(year, month, 27, 0xFF13acf0.toInt(), "多"))
        mCalendarView!!.setSchemeDate(schemes)

        mRecyclerView!!.layoutManager = LinearLayoutManager(activity)
        mRecyclerView!!.addItemDecoration(GroupItemDecoration<String, Article>())
        mRecyclerView!!.adapter = ArticleAdapter(activity)
        mRecyclerView!!.notifyDataSetChanged()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.iv_right -> {
                Toast.makeText(activity, "创建日程", Toast.LENGTH_LONG).show()
            }
            R.id.tv_month_day -> {
                //判断日历是否是开启状态
                if (!mCalendarLayout!!.isExpand) {
                    mCalendarView!!.showYearSelectLayout(mYear!!)
                    return;
                }
                mCalendarView!!.showYearSelectLayout(mYear!!)
                mLunar!!.visibility = View.GONE
                mTextYear!!.visibility = View.GONE
                mMonth_day!!.text = mYear!!.toString()
            }
            R.id.fl_current -> {
                mCalendarView!!.scrollToCurrent() //定位当前日期
            }

        }
    }

    /**
     * 点击选中改变日期
     */
    override fun onDateSelected(calendar: Calendar?, p1: Boolean) {
        mLunar!!.visibility = View.VISIBLE;
        mTextYear!!.visibility = View.VISIBLE;
        mMonth_day!!.text = "" + calendar!!.month + "月" + calendar!!.day + "日"
        mTextYear!!.text = "" + calendar.year
        mLunar!!.text = calendar.lunar
        mYear = calendar.year

    }

    /**
     * 年份改变
     */
    override fun onYearChange(year: Int) {
        mMonth_day!!.text = "" + year
    }

    private fun getSchemeCalendar(year: Int, month: Int, day: Int, color: Int, text: String): Calendar {
        var calendar = Calendar()
        calendar.year = year
        calendar.month = month
        calendar.day = day
        calendar.schemeColor = color  //如果单独标记颜色、则会使用这个颜色
        calendar.scheme = text
        calendar.addScheme(Calendar.Scheme())

        calendar.addScheme(0xFF008800.toInt(), "假")
        calendar.addScheme(0xFF008800.toInt(), "节")

        return calendar
    }


}