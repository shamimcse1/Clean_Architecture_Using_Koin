package com.codercamp.cleanarchitecturemvvm.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.servise.ResponseResult
import com.codercamp.cleanarchitecturemvvm.domain.useCase.GetProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val getProductUseCase: GetProductUseCase) : ViewModel() {

    private val _productState = MutableStateFlow<ResponseResult<List<Product>>>(ResponseResult.Loading())
    val productState: StateFlow<ResponseResult<List<Product>>> = _productState

    fun fetchProduct() {
        viewModelScope.launch {
            _productState.value = ResponseResult.Loading()
            _productState.value = getProductUseCase.invoke()
        }
    }
}