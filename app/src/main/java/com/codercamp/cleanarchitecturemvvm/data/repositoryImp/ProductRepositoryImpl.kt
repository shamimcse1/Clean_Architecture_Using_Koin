package com.codercamp.cleanarchitecturemvvm.data.repositoryImp

import com.codercamp.cleanarchitecturemvvm.data.data_Sources.local.ProductDao
import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.data_Sources.remote.ApiService
import com.codercamp.cleanarchitecturemvvm.data.helper.ResponseResult
import com.codercamp.cleanarchitecturemvvm.data.helper.toData
import com.codercamp.cleanarchitecturemvvm.data.helper.toDomain
import com.codercamp.cleanarchitecturemvvm.domain.repository.ProductRepository
import java.io.IOException

class ProductRepositoryImpl(private val api: ApiService,private val dao: ProductDao) :
    ProductRepository {
    override suspend fun getProduct(): ResponseResult<List<Product>> {
        return try {
            val products = api.getProduct()
            products.forEachIndexed { index, product ->
                dao.insertProduct(products[index].toData())
            }
            ResponseResult.Success(products)
        } catch (e: retrofit2.HttpException) {
            val allProducts = dao.getAllProducts()
            ResponseResult.Success(allProducts.map { it.toDomain() })
        }
        catch (e: IOException) {
            val allProducts = dao.getAllProducts()
            ResponseResult.Success(allProducts.map { it.toDomain() })
        }
        catch (e: Exception) {
            ResponseResult.Error(e.message ?: "An error occurred")
        }
    }
}