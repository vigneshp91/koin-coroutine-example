package com.example.mykoinapplication.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mykoinapplication.R
import com.example.mykoinapplication.databinding.ItemRecipeBinding
import com.example.mykoinapplication.ui.main.model.RecipeModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.StackFrom

class RecipeAdapter: RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>()  {
    private var recipies: List<RecipeModel>? = null
    lateinit var mContext: Context
     class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder = RecipeViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_recipe,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        recipies?.let {
            holder.binding.name.text = it[position].name
            holder.binding.price.text = it[position].price
            Glide.with(mContext).load(it[position].image).into(holder.binding.image)
            holder.binding.executePendingBindings()
        }
    }

    override fun getItemCount(): Int {
        var size = 0
        if(recipies!=null) {
            size= recipies!!.size
        }
        return  size
    }

    public fun setRecipes(data:ArrayList<RecipeModel>) {
        recipies = data
        notifyDataSetChanged()
    }
    public fun setContext(ctx:Context) {
        mContext = ctx
        notifyDataSetChanged()
    }
}


