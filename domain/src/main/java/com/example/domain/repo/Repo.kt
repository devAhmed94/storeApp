package com.example.domain.repo


import com.example.domain.entities.ProductsItem


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 17/06/2023
 */
interface Repo {
    suspend fun getProducts(): List<ProductsItem>
}