package org.himanshu.productbrowser.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(
    val id: Int,
    val title: String,
    val description: String,
    val brand: String? = null,
    val price: Double,
    val rating: Double,
    val thumbnail: String,
    val category: String
)