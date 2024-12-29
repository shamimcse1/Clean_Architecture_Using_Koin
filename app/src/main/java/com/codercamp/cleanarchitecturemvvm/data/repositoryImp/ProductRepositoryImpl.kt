package com.codercamp.cleanarchitecturemvvm.data.repositoryImp

import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.data_Sources.remote.ApiService
import com.codercamp.cleanarchitecturemvvm.data.helper.ResponseResult
import com.codercamp.cleanarchitecturemvvm.data.repository.ProductRepository

class ProductRepositoryImpl(private val api: ApiService) : ProductRepository {
    override suspend fun getProduct(): ResponseResult<List<Product>> {
        return try {
            val product = api.getProduct()
            ResponseResult.Success(product)
        } catch (e: retrofit2.HttpException) {
            when (e.code()) {
                401 -> ResponseResult.UnAuthorized("Unauthorized access")
                else -> ResponseResult.Error("Unexpected error: ${e.message()}")
            }
        } catch (e: Exception) {
            ResponseResult.Error(e.message ?: "An error occurred")
        }
    }
}