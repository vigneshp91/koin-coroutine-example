package com.example.mykoinapplication.ui.main.model

import com.google.gson.annotations.SerializedName

class UserModel {
    val data:UserDetails? = null

    class UserDetails {
        val id:Int = 0
        val email:String? = null
        @SerializedName("first_name")
        val firstName:String? = null
        @SerializedName("last_name")
        val lastName:String? = null
        val avatar:String? = null

    }
}