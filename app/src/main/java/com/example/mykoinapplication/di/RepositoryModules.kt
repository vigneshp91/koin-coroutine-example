package com.example.mykoinapplication.di

import com.example.mykoinapplication.ui.main.HomeRepository
import com.example.mykoinapplication.ui.main.HomeViewModel
import com.example.mykoinapplication.ui.main.IHomeRepo
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repositoryModules = module {
    factory<IHomeRepo> {
        return@factory HomeRepository(get())
    }

}