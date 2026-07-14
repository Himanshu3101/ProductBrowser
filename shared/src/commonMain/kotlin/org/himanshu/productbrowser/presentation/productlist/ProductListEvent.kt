package org.himanshu.productbrowser.presentation.productlist

sealed interface ProductListEvent{
    data object LoadProducts: ProductListEvent
    data class Search (val query: String) : ProductListEvent
    data class ProductClicked(val id: Int) : ProductListEvent
}