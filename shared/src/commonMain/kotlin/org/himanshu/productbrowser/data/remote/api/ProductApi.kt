package org.himanshu.productbrowser.data.remote.api

import org.himanshu.productbrowser.data.remote.dto.ProductDto
import org.himanshu.productbrowser.data.remote.dto.ProductResponseDto

interface ProductApi{

    suspend fun getProduct(): ProductResponseDto

    suspend fun getProduct(id:Int): ProductDto

    suspend fun searchProduct(query:String): ProductResponseDto
}