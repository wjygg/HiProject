package org.devio.hi.tab.bottom


import android.content.Context
import android.util.AttributeSet
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TabHost
import com.example.hi.hi_ui.R
import org.devio.hi.tab.common.IHiTabLayout
import org.devio.hi.tab.utils.DisplayUtils
import java.util.*

class HiTabBootomLayout : FrameLayout,IHiTabLayout<HiTabBottom,HITabBottomInfo<*>>{

    var infoList:List<HITabBottomInfo<*>> = ArrayList<HITabBottomInfo<*>>()
    var tabChangeListener: MutableList<IHiTabLayout.OnTabSelectedListener<HITabBottomInfo<*>>> = ArrayList()
    var selectInfo: HITabBottomInfo<*>? = null
    val bottomAlpha:Float = 1f
    val tabBottomHeight:Float=50f
    val bottomLineColor:String="def01e"
    var context1:Context? =null

    constructor(context: Context): this(context,null){
    }
     constructor(context: Context,  attrs: AttributeSet?):this(context,attrs,0) {
    }
     constructor( context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context,attrs,defStyleAttr) {
       this.context1=context
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
        selectInfo=null
        addBackGround()
        var frameLayout=FrameLayout(context1)
        var width=DisplayUtils.getDisplayWidthInPx(context1!!)/this.infoList.size
        for((index,item)in infoList.withIndex()){
            var layoutParams=FrameLayout.LayoutParams(width,DisplayUtils.displayPxToDp(context1!!,tabBottomHeight))
            layoutParams.leftMargin=index*width
            layoutParams.gravity=Gravity.BOTTOM

            var hiTabBottom=HiTabBottom(context1!!)
            hiTabBottom.setHiTabInfo(item)
            tabChangeListener.add(hiTabBottom)
            frameLayout.addView(hiTabBottom,layoutParams)
            hiTabBottom.setOnClickListener(object :OnClickListener{
                override fun onClick(p0: View?) {

                }
            })
        }


    }

    fun addBackGround(){
        var view: View =LayoutInflater.from(context1).inflate(R.layout.hi_bottom_layout_bg,null)
        var layoutParams:FrameLayout.LayoutParams=LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,DisplayUtils.displayPxToDp(context1!!,tabBottomHeight))
        layoutParams.gravity=Gravity.BOTTOM
        view.alpha=bottomAlpha
        addView(view,layoutParams)
    }



}

