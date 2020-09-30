package com.example.mykoinapplication

import android.app.Application
import com.example.mykoinapplication.di.networkModules
import com.example.mykoinapplication.di.repositoryModules
import com.example.mykoinapplication.di.viewModelModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@MyApplication)
            modules(listOf(viewModelModules, repositoryModules,networkModules))
        }


    }

}