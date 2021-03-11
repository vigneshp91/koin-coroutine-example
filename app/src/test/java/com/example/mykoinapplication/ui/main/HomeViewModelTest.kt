package com.example.mykoinapplication.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.mykoinapplication.network.ApiInterface
import com.example.mykoinapplication.ui.main.model.UserModel
import com.example.mykoinapplication.utils.TestCoroutineRule
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class HomeViewModelTest{
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var mRepo:IHomeRepo

    @Mock private lateinit var apiUsersObserver: Observer<UserModel>

    lateinit var viewModel: HomeViewModel
    @Before
    fun setup(){
         viewModel = HomeViewModel(mRepo)
    }

    @Test
    fun simpleTest(){
        testCoroutineRule.runBlockingTest {
            var result = UserModel()
            doReturn(result).`when`(mRepo).getDataFromService()
            viewModel.userData.observeForever(apiUsersObserver)
            verify(mRepo).getDataFromService()
            verify(apiUsersObserver).onChanged(result)
            viewModel.userData.removeObserver(apiUsersObserver)
        }

    }

    @Test
    fun `error simpleTest`(){
        testCoroutineRule.runBlockingTest {
            var result = UserModel()
            doReturn(result).`when`(mRepo).getDataFromService()
            viewModel.userData.observeForever(apiUsersObserver)
            verify(mRepo).getDataFromService()
            verify(apiUsersObserver).onChanged(result)
            viewModel.userData.removeObserver(apiUsersObserver)
        }

    }
}