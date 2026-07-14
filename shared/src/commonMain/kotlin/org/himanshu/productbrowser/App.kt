package org.himanshu.productbrowser

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import org.himanshu.productbrowser.di.AppModule
import org.himanshu.productbrowser.presentation.productlist.ProductListScreen

@Composable
@Preview
fun App() {

    val viewModel = remember { AppModule.provideProductListViewModel() }

    MaterialTheme {

        ProductListScreen(
            viewModel = viewModel,
            onProductClicked = {}
        )
    }
}