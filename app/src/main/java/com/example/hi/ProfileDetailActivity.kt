package com.example.hi

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.alibaba.android.arouter.facade.annotation.Route
import com.example.hi.router.RouterFlag


@Route(path = "/profile/detail",extras = RouterFlag.FLAG_VIP)
class ProfileDetailActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_detail_layout)
    }
}