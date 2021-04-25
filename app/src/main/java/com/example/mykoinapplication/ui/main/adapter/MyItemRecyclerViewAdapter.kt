package com.example.mykoinapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mykoinapplication.R
import com.example.mykoinapplication.ui.main.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val values: MutableList<DummyItem>
) : RecyclerView.Adapter<BaseViewHolder>() {
    var isLoaderVisible = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        if(viewType==1){
            view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_item_progress, parent, false)
            return ProgressViewHolder(view)
        }
        return ViewHolder(view)



    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if(holder is ViewHolder){
            val item = values[position]
            holder.idView.text = item.id
            holder.contentView.text = item.content
        }else if(holder is ProgressViewHolder){
            holder.progressView.visibility = View.VISIBLE
        }

    }

    override fun getItemCount(): Int = values.size
    override fun getItemViewType(position: Int): Int {
        return if(position==values.size-1)
            1//progress
        else
            0//data
    }

    fun addItems(items: MutableList<DummyItem>) {
        //values.addAll(items)
        notifyDataSetChanged()
    }

    fun addLoading() {
        isLoaderVisible = true
        values.add(DummyItem("", "", ""))
        notifyItemInserted(values.size - 1)
    }

    fun removeLoading() {
        isLoaderVisible = false
        val position: Int = values.size - 1
        val item: DummyItem = getItem(position)
        if (item != null) {
            values.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    private fun getItem(position: Int): DummyItem {
        return values[position]
    }


}