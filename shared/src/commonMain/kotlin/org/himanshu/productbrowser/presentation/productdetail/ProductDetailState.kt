package org.himanshu.productbrowser.presentation.productdetail

import org.himanshu.productbrowser.domain.model.Product

data class ProductDetailState(
    val isLoading:Boolean = false,
    val product: Product? = null,
    val error: String? = null
)