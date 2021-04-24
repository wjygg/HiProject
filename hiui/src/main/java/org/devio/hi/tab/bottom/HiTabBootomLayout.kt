package org.devio.hi.tab.bottom


import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import org.devio.hi.tab.common.IHiTabLayout

class HiTabBootomLayout : FrameLayout,IHiTabLayout<HiTabBottom,HITabBottomInfo<*>>{

    lateinit var infoList: List<HITabBottomInfo<*>>

    constructor(context: Context): this(context,null){
    }
     constructor(context: Context,  attrs: AttributeSet?):this(context,attrs,0) {
    }
     constructor( context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context,attrs,defStyleAttr) {

    }
    override fun findTab(data: HITabBottomInfo<*>): HiTabBottom {

        return  HiTabBottom(context)

    }

    override fun addTabSelectedChangeListener(onTabSelectedListener: IHiTabLayout.OnTabSelectedListener<HITabBottomInfo<*>>) {

    }

    override fun defaultSelected(defaultInfo: HITabBottomInfo<*>) {

    }

    override fun inflateInfo(infoList: List<HITabBottomInfo<*>>) {
        if(infoList.isEmpty()){
            return
        }
        this.infoList=infoList
        for (index in childCount -1 downTo 1) {
            if(index>0){
                removeViewAt(index)
            }
        }

    }
}