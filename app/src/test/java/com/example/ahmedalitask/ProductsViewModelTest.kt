package com.example.ahmedalitask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.ahmedalitask.presentation.listProducts.ProductsViewModel
import com.example.ahmedalitask.presentation.listProducts.ProductsViewStates
import com.example.domain.repo.Repo
import com.example.domain.useCases.GetProducts
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/06/2023
 */
class ProductsViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    private val repo = mockk<Repo> {
        coEvery { getProducts() } returns mockk()
    }


    @Before
    fun setUp() {
        Dispatchers.setMain(dispatcher)
    }

    @Test
    fun `getProducts() when Loading`() = runTest {

        val getProductsUseCase = mockk<GetProducts>()
        val viewModel = ProductsViewModel(getProductsUseCase)

        viewModel.getProducts()
        dispatcher.scheduler.advanceUntilIdle()

        assert(viewModel.products.value is ProductsViewStates.Loading)

    }



}