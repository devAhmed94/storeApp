package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entities.ProductsItem
import com.example.domain.repo.Repo


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 17/06/2023
 */
class ProductsRepoImp(private val apiService: ApiService) :Repo{
    override suspend fun getProducts(): List<ProductsItem> =apiService.getProducts()


}