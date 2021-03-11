package com.example.mykoinapplication.ui.main

import com.example.mykoinapplication.ui.main.model.UserModel

interface IHomeRepo {
    suspend fun getDataFromService():UserModel
}