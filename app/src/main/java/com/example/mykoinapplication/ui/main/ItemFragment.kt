package com.example.mykoinapplication.ui.main

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykoinapplication.R
import com.example.mykoinapplication.ui.main.adapter.MyItemRecyclerViewAdapter
import com.example.mykoinapplication.ui.main.dummy.DummyContent
import com.example.mykoinapplication.ui.main.listener.ScrollListener
import com.example.mykoinapplication.ui.main.listener.ScrollListener.Companion.PAGE_START

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    private var columnCount = 1
    var isLastPage = false
    var isLoading = false
    var currentPage = PAGE_START
    val totalPage = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyItemRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (view is RecyclerView && view.layoutManager is LinearLayoutManager) {
            val adapter = view.adapter as MyItemRecyclerViewAdapter
            view.addOnScrollListener(object :ScrollListener(view.layoutManager as LinearLayoutManager){
                override fun loadMoreItems() {
                    isLoading = true;
                    currentPage++;
                    Handler().postDelayed({
                        DummyContent.generateItems()
                        if (currentPage != PAGE_START) adapter.removeLoading();
                        adapter.addItems(DummyContent.ITEMS);
//                        swipeRefresh.setRefreshing(false);
                        if (currentPage < totalPage) {
                            adapter.addLoading();
                        } else {
                            isLastPage = true;
                        }
                        isLoading = false;
                    },1500)

                }

                override fun isLastPage(): Boolean {
                    return isLastPage
                }

                override fun isLoading(): Boolean {
                   return isLoading
                }

            })
        }
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
            ItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_COLUMN_COUNT, columnCount)
                }
            }
    }
}