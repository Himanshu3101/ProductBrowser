package org.himanshu.productbrowser.presentation.productdetail

sealed interface ProductDetailEvent {

    data class LoadProduct(
        val productId: Int
    ): ProductDetailEvent
}