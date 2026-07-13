package org.himanshu.productbrowser.domain.usecase

import org.himanshu.productbrowser.domain.model.Product
import org.himanshu.productbrowser.domain.repository.ProductRepository

class GetProductsUseCase(
    private val repository: ProductRepository
){
    suspend operator fun invoke(): List<Product>{
        return repository.getProducts()
    }
}