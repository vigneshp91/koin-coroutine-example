package com.example.mykoinapplication.ui.main

import android.content.Context
import android.widget.Toast

class HomeFragmentImpl(val context:Context):IHomeFragment {
    override fun showToast( msg: String) {
        Toast.makeText(context,msg, Toast.LENGTH_LONG).show()

    }
}