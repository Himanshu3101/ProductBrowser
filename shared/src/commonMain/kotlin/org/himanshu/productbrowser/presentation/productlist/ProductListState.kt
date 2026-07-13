package org.himanshu.productbrowser.presentation.productlist

import org.himanshu.productbrowser.domain.model.Product

data class ProductListState(
    val isLoading: Boolean = false,
    val products : List<Product> = emptyList(),
    val searchQuery: String = "",
    val error:String? = null
)