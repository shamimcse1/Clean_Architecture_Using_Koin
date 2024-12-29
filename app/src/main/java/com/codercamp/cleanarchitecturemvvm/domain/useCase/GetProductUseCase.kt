package com.codercamp.cleanarchitecturemvvm.domain.useCase

import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.servise.ResponseResult
import com.codercamp.cleanarchitecturemvvm.domain.repository.ProductRepository

class GetProductUseCase(private val repository: ProductRepository) {
    suspend operator fun invoke(): ResponseResult<List<Product>> = repository.getProduct()
}