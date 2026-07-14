package org.himanshu.productbrowser.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import org.himanshu.productbrowser.di.AppModule
import org.himanshu.productbrowser.presentation.productdetail.ProductDetailScreen
import org.himanshu.productbrowser.presentation.productlist.ProductListScreen
import androidx.savedstate.read

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val productListViewModel = remember {
        AppModule.provideProductListViewModel()
    }

    val productDetailViewModel = remember {
        AppModule.provideProductDetailViewModel()
    }

    NavHost(
        navController = navController,
        startDestination = Screen.ProductList.route
    ) {
        composable(Screen.ProductList.route) {

            ProductListScreen(
                viewModel = productListViewModel,
                onProductClicked = { productId ->
                    navController.navigate(
                        Screen.ProductDetail.createRoute(productId)
                    )
                }
            )
        }

        composable(
            Screen.ProductDetail.route,
            arguments = listOf(
                navArgument(
                    "id"
                ) {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.read {
                getInt("id")
            } ?: return@composable

            ProductDetailScreen(
                productId = productId,
                viewModel = productDetailViewModel,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}