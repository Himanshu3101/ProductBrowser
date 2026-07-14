package org.himanshu.productbrowser.presentation.productdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun ProductDetailScreen(
    productId: Int,
    viewModel: ProductDetailViewModel,
    onBackClick: ()-> Unit
){
    val state by viewModel.state.collectAsState()

    LaunchedEffect(productId){
        viewModel.onEvent(
            ProductDetailEvent.LoadProduct(productId)
        )
    }

    when{
        state.isLoading ->{
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }

        state.error != null -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(state.error!!)
            }
        }
        state.product != null -> {
            val product = state.product ?: return

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(16.dp)
            ){
                Button(
                    onClick = onBackClick
                ) {
                    Text("Back")
                }

                Spacer(modifier = Modifier.height(16.dp))

                AsyncImage(
                    model = product.thumbnail,
                    contentDescription = product.title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(250.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = product.title,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    "Brand: ${product.brand ?: "Unknown"}"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "Price: $${product.price}"
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    "⭐ ${product.rating}"
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(product.description)
            }
        }
    }
}