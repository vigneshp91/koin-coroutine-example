package com.example.mykoinapplication.ui.main

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mykoinapplication.R
import com.example.mykoinapplication.network.ResultWrapper
import com.example.mykoinapplication.ui.main.model.UserModel
import kotlinx.coroutines.currentCoroutineContext
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel

class HomeFragment(private val mFragmentImpl:IHomeFragment) : Fragment() {

    companion object {
        fun newInstance(ctx: Context) = HomeFragment(HomeFragmentImpl(ctx))
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
        getData()

    }

     fun getData(){
        viewModel.userData.observe(viewLifecycleOwner,{ data->
            when (data) {
                is ResultWrapper.NetworkError -> Toast.makeText(context,"NetworkError",Toast.LENGTH_LONG).show()
                is ResultWrapper.GenericError -> Toast.makeText(context,"NetworkError",Toast.LENGTH_LONG).show()
                is ResultWrapper.Success -> {
                    mFragmentImpl.showToast(data.value.data.toString())
                }
            }
        })
    }

}