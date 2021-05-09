package org.devio.hi.tab.common

import android.view.ViewGroup


interface IHiTabLayout<Tab:ViewGroup,D> {

    fun findTab(data:D):Tab?

    fun addTabSelectedChangeListener(onTabSelectedListener:OnTabSelectedListener<D>)

    fun defaultSelected(defaultInfo:D)

    fun inflateInfo(infoList:List<D>)

    interface OnTabSelectedListener<D>{

        fun onTabSelectListener(index:Int,prevInfo:D?,next:D)
    }

}