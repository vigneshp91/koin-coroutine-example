package com.example.mykoinapplication.ui.main.model

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable


class RecipeModel:Comparable<RecipeModel> {
    val id:Int? = 0
    val name:String? = null
    val image:String? = null
    val category:String? = null
    val label:String? = null
    val price:String? = null
    val description:String? = null

    override fun compareTo(other: RecipeModel): Int {
        val thisPrice = this.price?.toFloat()
        val otherPrice = other.price?.toFloat()
        return (thisPrice!!- otherPrice!!).toInt()
    }

}