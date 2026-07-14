package org.himanshu.productbrowser.presentation.productlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.himanshu.productbrowser.presentation.components.ProductCard

@Composable
fun ProductListScreen(
    viewModel: ProductListViewModel,
    onProductClicked: (Int) -> Unit
){
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize()
    ){

        OutlinedTextField(
            value = state.searchQuery,
            onValueChange = {
                viewModel.onEvent(
                    ProductListEvent.Search(it)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            placeholder = {
                Text("Search Product...")
            }
        )

        if(state.isLoading){
            Box(modifier = Modifier.fillMaxSize()){
                CircularProgressIndicator()
            }
        }else{
            LazyColumn {
                items(state.products){ product ->
                    ProductCard(
                        product = product,
                        onClick = {onProductClicked(product.id)}
                    )
                }
            }
        }
    }
}
