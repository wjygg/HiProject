package org.devio.hi.tab.bottom

import android.content.Context
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.widget.FrameLayout
import java.lang.RuntimeException

class HIFragmentTabView :FrameLayout{

    private lateinit var hiTabViewAdapter:HiTabViewAdapter

    constructor(context: Context):this(context,null){

    }
    constructor(context: Context, attrs: AttributeSet?):this(context,attrs,0){

    }
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr:Int):super(context,attrs,defStyleAttr){

    }

    fun setAdapter(hiTabViewAdapter: HiTabViewAdapter?){
        if(hiTabViewAdapter==null){
            return
        }
        this.hiTabViewAdapter=hiTabViewAdapter
    }

    fun setCurrentItem(position:Int){
        //数组越界
        if(position<0||position>=hiTabViewAdapter.getCount()){
            return
        }
        hiTabViewAdapter.instantiateItem(this,position);
    }

    fun getCurrentFragment():Fragment{
        if(hiTabViewAdapter==null){
          throw RuntimeException("没有设置adapter")
        }
        return hiTabViewAdapter.getCurrentFragment()
    }

}