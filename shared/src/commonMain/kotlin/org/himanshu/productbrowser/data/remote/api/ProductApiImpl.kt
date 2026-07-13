package org.himanshu.productbrowser.data.remote.api

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import org.himanshu.productbrowser.core.network.NetworkConstants
import org.himanshu.productbrowser.data.remote.dto.ProductDto
import org.himanshu.productbrowser.data.remote.dto.ProductResponseDto

class ProductApiImpl(
    private val client: HttpClient
) : ProductApi {
    override suspend fun getProduct(): ProductResponseDto {
        return client.get(NetworkConstants.PRODUCTS).body()
    }

    override suspend fun getProduct(id: Int): ProductDto {
        return client.get("${NetworkConstants.PRODUCTS}/$id").body()
    }

    override suspend fun searchProduct(query: String): ProductResponseDto {
        return client.get(NetworkConstants.SEARCH){
            parameter("q", query)
        }.body()
    }
}