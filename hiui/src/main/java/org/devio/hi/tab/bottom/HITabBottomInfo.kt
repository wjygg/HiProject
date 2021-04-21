package org.devio.hi.tab.bottom

import android.graphics.Bitmap
import android.support.v4.app.Fragment

class HITabBottomInfo<Color> {
     enum class TabType{
       BITMAP,ICON
    }


    var fragment:Class<out Fragment>?=null
    var name:String?=null
    var defaultBitmap: Bitmap?=null
    var selectedBitmap: Bitmap?=null
    var iconFont: String?=null



    var defaultIconName:String?=null
    var selectIconName: Bitmap?=null
    var defaultColor: Color?=null
    var tinkColor: Color?=null
    var tabType: TabType?=null

    constructor(name:String,defaultBitmap:Bitmap,selectedBitmap:Bitmap){
        this.name=name
        this.defaultBitmap
        this.selectedBitmap=selectedBitmap
    }

    constructor(name:String,defaultIconName:String, selectIconName: Bitmap, defaultColor: Color,tinkColor: Color, tabType: TabType){
        this.name=name
        this.defaultIconName=defaultIconName
        this.selectIconName=selectIconName
        this.defaultColor=defaultColor
        this.tinkColor=tinkColor
        this.tabType=tabType
    }
}