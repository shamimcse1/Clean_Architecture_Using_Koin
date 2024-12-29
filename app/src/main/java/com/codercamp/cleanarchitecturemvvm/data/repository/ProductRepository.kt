package com.codercamp.cleanarchitecturemvvm.data.repository

import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.helper.ResponseResult

interface ProductRepository {
    suspend fun getProduct(): ResponseResult<List<Product>>
}