package com.codercamp.cleanarchitecturemvvm.domain.useCase

import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.helper.ResponseResult
import com.codercamp.cleanarchitecturemvvm.data.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(): ResponseResult<List<Product>> = repository.getProduct()
}