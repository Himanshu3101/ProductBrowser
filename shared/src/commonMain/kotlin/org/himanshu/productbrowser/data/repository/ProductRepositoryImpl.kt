package org.himanshu.productbrowser.data.repository

import org.himanshu.productbrowser.data.remote.api.ProductApi
import org.himanshu.productbrowser.data.remote.mapper.toDomain
import org.himanshu.productbrowser.domain.model.Product
import org.himanshu.productbrowser.domain.repository.ProductRepository

class ProductRepositoryImpl (private val api: ProductApi): ProductRepository {
    override suspend fun getProducts(): List<Product> {
        return api.getProduct().products.map { it.toDomain() }
    }

    override suspend fun getProducts(id: Int): Product {
        return api.getProduct(id).toDomain()
    }

    override suspend fun searchProduct(query: String): List<Product> {
        return api.searchProduct(query).products.map{it.toDomain()}
    }
}