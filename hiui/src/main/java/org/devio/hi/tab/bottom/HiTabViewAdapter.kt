package org.devio.hi.tab.bottom

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import java.lang.Exception

class HiTabViewAdapter {

    private  var mInfoList:MutableList<HITabBottomInfo<*>>
    private  var mCurrentFragment:Fragment ?=null
    private  var mFragmentManager: FragmentManager

    constructor(mFragmentManager: FragmentManager,mInfoList:MutableList<HITabBottomInfo<*>>){
        this.mInfoList=mInfoList
        this.mFragmentManager=mFragmentManager
    }

    fun instantiateItem(container: View,position:Int){
        val beginTransaction: FragmentTransaction = mFragmentManager.beginTransaction()
        if(mCurrentFragment!=null){
            beginTransaction.hide(mCurrentFragment!!)
        }
        var name:String= container.id.toString()+position.toString()
        var fragment = mFragmentManager.findFragmentByTag(name)
        if(fragment!=null){
            beginTransaction.show(fragment)
        }else{
            fragment = getItem(position)
            beginTransaction.add(container.id,fragment!!,name)
        }
        mCurrentFragment=fragment
        beginTransaction.commitAllowingStateLoss()
    }

    private fun getItem(position:Int):Fragment?{
        val fragment: Class<out Fragment>? = mInfoList.get(position).fragment
        try {
            return fragment!!.newInstance()
        }catch (e:Exception){
            e.printStackTrace()
        }
        return  null
    }

    fun getCount():Int{
        return mInfoList.size
    }

    fun getCurrentFragment():Fragment{
        return mCurrentFragment!!
    }



}