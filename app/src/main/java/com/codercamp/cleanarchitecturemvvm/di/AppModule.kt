package com.codercamp.cleanarchitecturemvvm.di

import androidx.room.Room
import com.codercamp.cleanarchitecturemvvm.constants.Constants
import com.codercamp.cleanarchitecturemvvm.data.dataSources.local.AppDatabase
import com.codercamp.cleanarchitecturemvvm.data.repositoryImp.ProductRepositoryImpl
import com.codercamp.cleanarchitecturemvvm.data.dataSources.remote.ApiService
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
        Room.databaseBuilder(get(), AppDatabase::class.java, "app_database").build()
    }
    single { get<AppDatabase>().productDao() }

    single {
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    single<ProductRepository> { ProductRepositoryImpl(get(),get()) }

    factory { GetProductUseCase(get()) }

    viewModel { ProductViewModel(get()) }

}