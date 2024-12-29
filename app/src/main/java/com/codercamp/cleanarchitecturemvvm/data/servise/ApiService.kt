package com.codercamp.cleanarchitecturemvvm.data.servise

import com.codercamp.cleanarchitecturemvvm.data.model.Product
import retrofit2.http.GET

interface ApiService {
    @GET("products")
    suspend fun getProduct(): List<Product>
}