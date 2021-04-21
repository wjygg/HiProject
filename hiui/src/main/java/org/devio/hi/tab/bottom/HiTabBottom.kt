package org.devio.hi.tab.bottom

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import org.devio.hi.tab.common.IHiTab

class HiTabBottom : RelativeLayout, IHiTab<HITabBottomInfo<*>> {

    override fun setHiTabInfo(data: HITabBottomInfo<*>) {

    }

    override fun resetHeight(height: Int) {

    }

    override fun onTabSelectListener(index: Int, prevInfo: HITabBottomInfo<*>, next: HITabBottomInfo<*>) {

    }


    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs) {


    }

}