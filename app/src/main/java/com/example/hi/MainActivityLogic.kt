package com.example.hi

import android.content.res.Resources
import android.graphics.BitmapFactory
import android.support.annotation.IdRes
import android.support.annotation.StringRes
import android.support.v4.app.FragmentManager
import android.view.View
import org.devio.hi.tab.bottom.HIFragmentTabView
import org.devio.hi.tab.bottom.HITabBottomInfo
import org.devio.hi.tab.bottom.HiTabBootomLayout
import org.devio.hi.tab.bottom.HiTabViewAdapter
import org.devio.hi.tab.common.IHiTabLayout

class MainActivityLogic {

    lateinit var hiTabBootomLayout:HiTabBootomLayout
    lateinit var hiFragmentTabView: HIFragmentTabView
    lateinit var infoList: MutableList<HITabBottomInfo<*>>
    lateinit var activityProvider: ActivityProvider

    constructor(activityProvider:ActivityProvider){
        this.activityProvider=activityProvider
        initTabBottom()
    }

    fun initTabBottom(){
        hiTabBootomLayout=activityProvider.findViewById<HiTabBootomLayout>(R.id.hi_tab_bootom_layout)
        infoList=ArrayList()


        var homeInfo=HITabBottomInfo("首页", BitmapFactory.decodeResource(activityProvider.getResources(),R.mipmap.icon_home_unsel),
                BitmapFactory.decodeResource(activityProvider.getResources(),R.mipmap.icon_home_sel),
                activityProvider.getResources()!!.getColor(R.color.colorPrimary),
                activityProvider.getResources()!!.getColor(R.color.colorAccent))
        homeInfo.fragment=HomeFragement::class.java
        infoList.add(homeInfo)

        var mineInfo=HITabBottomInfo("我的", BitmapFactory.decodeResource(activityProvider.getResources(),R.mipmap.icon_mine_unsel),
                BitmapFactory.decodeResource(activityProvider.getResources(),R.mipmap.icon_mine_sel),
                activityProvider.getResources()!!.getColor(R.color.colorPrimary),
                activityProvider.getResources()!!.getColor(R.color.colorAccent))
        mineInfo.fragment=MineFragment::class.java
        infoList.add(mineInfo)
        hiTabBootomLayout.inflateInfo(infoList)
        initHIFragmentTabView()
        hiTabBootomLayout.addTabSelectedChangeListener(object: IHiTabLayout.OnTabSelectedListener<HITabBottomInfo<*>>{
            override fun onTabSelectListener(index: Int, prevInfo: HITabBottomInfo<*>?, next: HITabBottomInfo<*>) {
                if(hiFragmentTabView!=null){
                    hiFragmentTabView.setCurrentItem(index)
                }
            }
        })
        hiTabBootomLayout.defaultSelected(homeInfo)
    }

    fun initHIFragmentTabView(){
        var hiTabViewAdapter=HiTabViewAdapter(activityProvider.getSupportFragmentManager()!!,infoList)
        this.hiFragmentTabView= activityProvider.findViewById(R.id.hi_fragement_tab_view)
        hiFragmentTabView.setAdapter(hiTabViewAdapter)
    }


    interface ActivityProvider{
        fun <T : View?> findViewById(@IdRes id: Int): T
        fun getResources(): Resources?
        fun getSupportFragmentManager(): FragmentManager?
        fun getString(@StringRes resId: Int): String
    }

}