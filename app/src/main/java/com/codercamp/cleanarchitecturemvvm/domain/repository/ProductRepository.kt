package com.codercamp.cleanarchitecturemvvm.domain.repository

import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.servise.ResponseResult

interface ProductRepository {
    suspend fun getProduct(): ResponseResult<List<Product>>
}