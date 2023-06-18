package com.example.domain.useCases


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 17/06/2023
 */

class GetProducts(private val repo: com.example.domain.repo.Repo) {
    suspend  operator fun invoke () = repo.getProducts()
}