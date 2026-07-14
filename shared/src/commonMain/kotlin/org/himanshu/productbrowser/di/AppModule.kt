package org.himanshu.productbrowser.di

import org.himanshu.productbrowser.core.network.HttpClientFactory
import org.himanshu.productbrowser.data.remote.api.ProductApi
import org.himanshu.productbrowser.data.remote.api.ProductApiImpl
import org.himanshu.productbrowser.data.repository.ProductRepositoryImpl
import org.himanshu.productbrowser.domain.repository.ProductRepository
import org.himanshu.productbrowser.domain.usecase.GetProductUseCase
import org.himanshu.productbrowser.domain.usecase.GetProductsUseCase
import org.himanshu.productbrowser.domain.usecase.SearchProductsUseCase
import org.himanshu.productbrowser.presentation.productdetail.ProductDetailViewModel
import org.himanshu.productbrowser.presentation.productlist.ProductListViewModel

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

    private val getProductsUseCase = GetProductsUseCase(repository)

    private val getProductUseCase = GetProductUseCase(repository)

    private val searchProductsUseCase = SearchProductsUseCase(repository)

    fun provideProductListViewModel(): ProductListViewModel{
        return ProductListViewModel(
            getProductsUseCase = getProductsUseCase,
            searchProductsUseCase = searchProductsUseCase
        )
    }

    fun provideProductDetailViewModel() : ProductDetailViewModel{
        return ProductDetailViewModel(
            getProductUseCase = getProductUseCase
        )
    }


}