package com.example.mykoinapplication.ui.main

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
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.compat.ScopeCompat.viewModel

class HomeFragment : Fragment() {

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
        viewModel.userData.observe(viewLifecycleOwner,{ data->
            when (data) {
                is ResultWrapper.NetworkError -> Toast.makeText(context,"NetworkError",Toast.LENGTH_LONG).show()
                is ResultWrapper.GenericError -> Toast.makeText(context,"NetworkError",Toast.LENGTH_LONG).show()
                is ResultWrapper.Success -> {
                        Toast.makeText(context,data.value.data.toString(),Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}