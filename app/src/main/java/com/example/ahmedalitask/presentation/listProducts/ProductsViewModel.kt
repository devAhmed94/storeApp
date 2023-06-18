package com.example.ahmedalitask.presentation.listProducts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.useCases.GetProducts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 17/06/2023
 */
@HiltViewModel
class ProductsViewModel @Inject constructor(private val getProductsUseCase: GetProducts) :
    ViewModel() {
    private lateinit var job: Job
    private val _products = MutableLiveData<ProductsViewStates>()
    val products: LiveData<ProductsViewStates>
        get() = _products


    fun getProducts() {
        job = viewModelScope.launch (Dispatchers.IO){
            _products.postValue(ProductsViewStates.Loading)
            try {
                val productsUseCase = getProductsUseCase()
                _products.postValue(ProductsViewStates.Content(productsUseCase))
            } catch (e: java.lang.Exception) {
                _products.postValue(ProductsViewStates.Error(e.message.toString()))
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) {
            job.cancel()
        }
    }

}