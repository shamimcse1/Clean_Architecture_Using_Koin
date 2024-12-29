package com.codercamp.cleanarchitecturemvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.codercamp.cleanarchitecturemvvm.presentation.screen.ProductListScreen
import com.codercamp.cleanarchitecturemvvm.presentation.theme.CleanArchitectureMVVMTheme
import com.codercamp.cleanarchitecturemvvm.presentation.viewModel.ProductViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val productListViewModel: ProductViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            CleanArchitectureMVVMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
                        ProductListScreen(viewModel = productListViewModel)
                }
            }
            productListViewModel.fetchProduct()
        }
    }
}
