package com.example.mykoinapplication.ui.main

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.mykoinapplication.R
import com.example.mykoinapplication.ui.main.adapter.RecipeAdapter.RecipeViewHolder

import com.example.mykoinapplication.ui.main.model.RecipeModel

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class MyCartRecyclerViewAdapter(
    private val values: List<RecipeModel>, private val mContext:Context
) :RecyclerView.Adapter<RecipeViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeViewHolder = RecipeViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recipe,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        values?.let {
            holder.binding.name.text = it[position].name
            holder.binding.price.text = it[position].price
            Glide.with(mContext).load(it[position].image).into(holder.binding.image)
            holder.binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        return  values.size
    }


}