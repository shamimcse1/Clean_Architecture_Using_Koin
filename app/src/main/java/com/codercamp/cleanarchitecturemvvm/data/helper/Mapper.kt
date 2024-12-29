package com.codercamp.cleanarchitecturemvvm.data.helper

import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.domain.entity.ProductEntity

fun ProductEntity.toDomain() = Product(id, title, price, description, image)
fun Product.toData() = ProductEntity(id, title, price, description, image)