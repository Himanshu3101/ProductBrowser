package org.himanshu.productbrowser.di

import org.himanshu.productbrowser.core.network.HttpClientFactory
import org.himanshu.productbrowser.data.remote.api.ProductApi
import org.himanshu.productbrowser.data.remote.api.ProductApiImpl
import org.himanshu.productbrowser.data.repository.ProductRepositoryImpl
import org.himanshu.productbrowser.domain.repository.ProductRepository
import org.himanshu.productbrowser.domain.usecase.GetProductUseCase
import org.himanshu.productbrowser.domain.usecase.GetProductsUseCase
import org.himanshu.productbrowser.domain.usecase.SearchProductsUseCase

//It will create and expose:
//HttpClient
//ProductApi
//ProductRepository
//GetProductsUseCase
//SearchProductsUseCase
//GetProductUseCase

object AppModule{
    private val httpClient = HttpClientFactory.create()

    private val productApi: ProductApi = ProductApiImpl(httpClient)

    private val repository: ProductRepository = ProductRepositoryImpl(productApi)

    val getProductsUseCase = GetProductsUseCase(repository)

    val getProductUseCase = GetProductUseCase(repository)

    val searchProductsUseCase = SearchProductsUseCase(repository)


}