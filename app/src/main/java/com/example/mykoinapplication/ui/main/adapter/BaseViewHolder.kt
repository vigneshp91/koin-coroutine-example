package com.example.mykoinapplication.ui.main.adapter

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mykoinapplication.R

open class BaseViewHolder (view: View):RecyclerView.ViewHolder(view)

 class ViewHolder(view: View) : BaseViewHolder(view) {
    val idView: TextView = view.findViewById(R.id.item_number)
    val contentView: TextView = view.findViewById(R.id.content)

    override fun toString(): String {
        return super.toString() + " '" + contentView.text + "'"
    }
}

class ProgressViewHolder(view: View) : BaseViewHolder(view) {
    val progressView: ProgressBar = view.findViewById(R.id.progress)
}