package org.himanshu.productbrowser.presentation.navigation

sealed class Screen(val route: String){
    data object ProductList : Screen("product_list")

    data object ProductDetail : Screen("product_detail/{id}"){
        fun createRoute(id: Int): String{
            return "product_detail/$id"
        }
    }
}