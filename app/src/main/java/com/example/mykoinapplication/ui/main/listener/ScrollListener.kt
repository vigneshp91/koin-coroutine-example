package com.example.mykoinapplication.ui.main.listener

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class ScrollListener(val layoutManager: LinearLayoutManager): RecyclerView.OnScrollListener() {


    companion object{
         val PAGE_SIZE = 10
        val PAGE_START = 1
    }

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
    }

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        Log.d("totalItemCount", "${layoutManager.itemCount}")
        val visibleItemCount = layoutManager.childCount
        val totalItemCount = layoutManager.itemCount
        val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()
        Log.d("firstVisibleItem", "${firstVisibleItemPosition}")

        Log.d("cond", "${visibleItemCount + firstVisibleItemPosition}")
        if(!isLoading() && !isLastPage()){
            if((visibleItemCount+firstVisibleItemPosition >=totalItemCount)
                && firstVisibleItemPosition>=0
                && totalItemCount>=PAGE_SIZE){
                loadMoreItems()
            }
        }

    }

    protected abstract fun loadMoreItems()
    abstract fun isLastPage(): Boolean
    abstract fun isLoading(): Boolean
}