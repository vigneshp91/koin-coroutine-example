package com.example.mykoinapplication.di

import com.example.mykoinapplication.ui.main.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModules = module {
    viewModel { HomeViewModel(get()) }

}