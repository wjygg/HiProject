package org.devio.hi.tab.utils

import android.content.Context
import android.util.TypedValue

object DisplayUtils {

    fun displayPxToDp(context: Context,value:Float):Float{
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,value,context.getResources().displayMetrics)
    }

    fun getDisplayWidthInPx(context: Context):Int{
        return context.resources.displayMetrics.widthPixels
    }

}