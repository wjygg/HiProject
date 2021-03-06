package org.devio.hi.tab.bottom

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import com.example.hi.hi_ui.R
import org.devio.hi.tab.common.IHiTab

class HiTabBottom : RelativeLayout, IHiTab<HITabBottomInfo<*>> {

    var hiContext:Context
    lateinit var ivImageView:ImageView
    lateinit var tvName:TextView
    lateinit var hiTabBottomInfo: HITabBottomInfo<*>

    constructor(context: Context) : this(context, null) {

    }

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0) {

    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs) {
        this.hiContext=context
        init()
    }

    fun init(){
        LayoutInflater.from(hiContext).inflate(R.layout.hi_tab_bottom,this)
        ivImageView=findViewById(R.id.iv_image)
        tvName=findViewById(R.id.tv_name)
    }

    override fun setHiTabInfo(data: HITabBottomInfo<*>) {
        this.hiTabBottomInfo=data
        inflateInfo(false,true)
    }

    fun getHiTabInfo():HITabBottomInfo<*>{
        return this.hiTabBottomInfo
    }
    /**
     * 是否选中  是否初始化
     */
    fun inflateInfo(selected:Boolean,init:Boolean){
        if(hiTabBottomInfo.tabType==HITabBottomInfo.TabType.BITMAP){ //是图标模式
            if(init){
                ivImageView.setImageBitmap(hiTabBottomInfo.defaultBitmap)
                tvName.setText(hiTabBottomInfo.name)
                tvName.setTextColor(getTextColor(hiTabBottomInfo.defaultColor!!))
            }
            if(selected){
                ivImageView.setImageBitmap(hiTabBottomInfo.selectedBitmap)
                tvName.setTextColor(getTextColor(hiTabBottomInfo.tinkColor!!))
            }else{
                ivImageView.setImageBitmap(hiTabBottomInfo.defaultBitmap)
                tvName.setTextColor(getTextColor(hiTabBottomInfo.defaultColor!!))
            }
        }
    }



    override fun resetHeight(height: Int) {
        var layoutParams:ViewGroup.LayoutParams=layoutParams
        layoutParams.height=height
        setLayoutParams(layoutParams)
        tvName.visibility = View.GONE
    }

    fun getTextColor(color:Any):Int{
        if(color is String){
            return Color.parseColor(color)
        }else{
            return color as Int
        }
    }

    fun onTabSelectListener(index: Int, isSelect: Boolean, prevInfo: HITabBottomInfo<*>?) {
        inflateInfo(isSelect,false)
    }


}