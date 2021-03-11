package com.example.mykoinapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

import com.example.mykoinapplication.ui.main.model.UserModel

class HomeViewModel(private val repo:IHomeRepo) : ViewModel() {

    val userData: LiveData<UserModel> = liveData {
        emit(repo.getDataFromService())
    }
}