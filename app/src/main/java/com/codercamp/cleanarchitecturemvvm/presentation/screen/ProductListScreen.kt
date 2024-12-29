package com.codercamp.cleanarchitecturemvvm.presentation.screen

import android.media.Image
import android.util.Log
import android.widget.ImageView
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.codercamp.cleanarchitecturemvvm.data.model.Product
import com.codercamp.cleanarchitecturemvvm.data.servise.ResponseResult
import com.codercamp.cleanarchitecturemvvm.presentation.theme.CleanArchitectureMVVMTheme
import com.codercamp.cleanarchitecturemvvm.presentation.viewModel.ProductViewModel

@Composable
fun ProductListScreen(viewModel: ProductViewModel) {
    val productState = viewModel.productState.collectAsState()

    when (val state = productState.value) {
        is ResponseResult.Loading -> {

            LoadingIndicator()
        }

        is ResponseResult.Success -> {
            state.data?.let { product ->

                LazyVerticalGrid(
                    contentPadding = PaddingValues(0.dp),
                    columns = GridCells.Fixed(2), // 2 columns per row
                ) {
                    items(product.size) { index ->
                        ProductItem(product[index])
                    }
                }
            }
        }

        is ResponseResult.Error -> {
            Text("Error: ${state.message}")
        }

        is ResponseResult.UnAuthorized -> {
            Text("Unauthorized: ${state.message}")
        }
    }
}

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(), // Makes Box fill the available space
        contentAlignment = Alignment.Center // Centers content inside the Box
    ) {
        CircularProgressIndicator()
    }
}

@Composable()
fun ProductItem(product: Product) {

    CleanArchitectureMVVMTheme {

        Card(
            modifier = Modifier.padding(16.dp, end = 16.dp, top = 30.dp, bottom = 30.dp)
        ) {
            Column() {
                AsyncImage(
                    model = product.image, // Image URL
                    contentDescription = "Network Image",
                    modifier = Modifier
                        .padding(8.dp)
                        .width(200.dp)
                        .height(200.dp),
                    contentScale = ContentScale.Crop,

                    )
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(product.title, style = TextStyle(fontSize = 20.sp))
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Price: ${product.price}")
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        product.description, maxLines = 3
                    )
                }

            }
        }


    }

}