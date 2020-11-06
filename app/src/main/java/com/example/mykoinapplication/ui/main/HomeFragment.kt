package com.example.mykoinapplication.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.mykoinapplication.R
import com.example.mykoinapplication.network.ResultWrapper
import com.example.mykoinapplication.ui.main.adapter.RecipeAdapter
import com.example.mykoinapplication.ui.main.model.RecipeModel
import com.yuyakaido.android.cardstackview.CardStackLayoutManager
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import com.yuyakaido.android.cardstackview.SwipeableMethod
import kotlinx.android.synthetic.main.main_fragment.*
import org.koin.android.ext.android.inject
import kotlin.collections.ArrayList

class HomeFragment : Fragment(),CardStackListener {
    private val adapter = RecipeAdapter()
    private lateinit var layoutManager: CardStackLayoutManager
    private var cart:ArrayList<RecipeModel> = arrayListOf()
    private var recipies:ArrayList<RecipeModel> = arrayListOf()
    private var currPosition = 0

    companion object {
        fun newInstance() = HomeFragment()
    }

    private val viewModel : HomeViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        layoutManager = CardStackLayoutManager(context, this).apply {
            setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
            setOverlayInterpolator(LinearInterpolator())
        }

        progress.visibility = View.VISIBLE
        stack_view.layoutManager = layoutManager
        stack_view.adapter = adapter
        context?.let { adapter.setContext(it) }
        stack_view.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
        viewModel.recipeDate.observe(viewLifecycleOwner,{ data->
            when (data) {
                is ResultWrapper.NetworkError -> Toast.makeText(context,"NetworkError",Toast.LENGTH_LONG).show()
                is ResultWrapper.GenericError -> Toast.makeText(context,"NetworkError",Toast.LENGTH_LONG).show()
                is ResultWrapper.Success -> {
                    progress.visibility = View.GONE
                    recipies = data.value
                    adapter.setRecipes(recipies)
                }
            }
        })

        cart_view.setOnClickListener {
                (activity as HomeActivity).openCart(cart)
        }

        price_sort.setOnClickListener {
            recipies.sort();
            adapter.setRecipes(recipies)
        }
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
        if(direction == Direction.Right) {
            cart.add(recipies[currPosition])
            recipies.add(recipies.removeAt(currPosition))
            Toast.makeText(context, "Item added to cart", Toast.LENGTH_LONG).show()
        }else if(direction == Direction.Left){
            recipies.add(recipies.removeAt(currPosition))
            adapter.setRecipes(recipies)
        }
    }

    override fun onCardRewound() {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
        currPosition = position
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        currPosition = position
    }

}