package org.himanshu.productbrowser.domain.usecase

import org.himanshu.productbrowser.domain.model.Product
import org.himanshu.productbrowser.domain.repository.ProductRepository

class SearchProductsUseCase(
    private val repository: ProductRepository
){
    suspend operator fun invoke(query: String): List<Product>{
        return repository.searchProduct(query)
    }
}