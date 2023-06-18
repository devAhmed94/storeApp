package com.example.data.remote

import com.example.domain.entities.ProductsItem
import retrofit2.http.GET


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 17/06/2023
 */

interface ApiService {

    @GET("products")
    suspend fun getProducts(): List<ProductsItem>
}