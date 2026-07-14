package org.himanshu.productbrowser.domain.repository

import org.himanshu.productbrowser.domain.model.Product

interface ProductRepository{
    suspend fun getProducts(): List<Product>
    suspend fun getProduct(id:Int): Product
    suspend fun searchProduct(query: String) : List<Product>
}