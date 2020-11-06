package com.example.mykoinapplication.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykoinapplication.R
import com.example.mykoinapplication.ui.main.model.RecipeModel

/**
 * A fragment representing a list of Items.
 */
class CartFragment : Fragment() {

    private var cartValues:ArrayList<RecipeModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            cartValues = it.getSerializable(CART_VALUES) as ArrayList<RecipeModel>
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
                layoutManager = LinearLayoutManager(context)
                adapter = MyCartRecyclerViewAdapter(cartValues,context)
            }
        }
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as HomeActivity).title = "Recipe"
    }

    companion object {

        // TODO: Customize parameter argument names
        const val CART_VALUES = "cart-values"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: ArrayList<RecipeModel>) =
            CartFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(CART_VALUES, columnCount)
                }
            }
    }
}