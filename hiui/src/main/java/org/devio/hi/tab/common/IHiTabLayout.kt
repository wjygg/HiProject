package org.devio.hi.tab.common

import android.view.ViewGroup
import org.devio.hi.tab.bottom.HITabBottomInfo


interface IHiTabLayout<Tab:ViewGroup,D> {

    fun findTab(data:D):Tab?

    fun addTabSelectedChangeListener(onTabSelectedListener:OnTabSelectedListener<D>)

    fun defaultSelected(defaultInfo:D)

    fun inflateInfo(infoList:List<D>)

    interface OnTabSelectedListener<D>{
        fun onTabSelectListener(index:Int,isSelect:Boolean,prevInfo:D?)
    }

}