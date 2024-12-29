package com.codercamp.cleanarchitecturemvvm.di

import com.codercamp.cleanarchitecturemvvm.constants.Constants
import com.codercamp.cleanarchitecturemvvm.data.repositoryImp.ProductRepositoryImpl
import com.codercamp.cleanarchitecturemvvm.data.servise.ApiService
import com.codercamp.cleanarchitecturemvvm.domain.repository.ProductRepository
import com.codercamp.cleanarchitecturemvvm.domain.useCase.GetProductUseCase
import com.codercamp.cleanarchitecturemvvm.presentation.viewModel.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule: Module = module {
    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    single<ProductRepository> { ProductRepositoryImpl(get()) }

    factory { GetProductUseCase(get()) }

    viewModel { ProductViewModel(get()) }

}