package com.example.ahmedalitask.presentation.listProducts

import com.example.domain.entities.ProductsItem


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 18/06/2023
 */
sealed class ProductsViewStates {
    object Loading : ProductsViewStates()
    data class Error(val msg: String) : ProductsViewStates()
    data class Content(val productList: List<ProductsItem>) : ProductsViewStates()
}
