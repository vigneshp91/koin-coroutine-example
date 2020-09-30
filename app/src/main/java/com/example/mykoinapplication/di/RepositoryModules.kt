package com.example.mykoinapplication.di

import com.example.mykoinapplication.ui.main.HomeRepository
import com.example.mykoinapplication.ui.main.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModules = module {
    single { HomeRepository(get()) }

}