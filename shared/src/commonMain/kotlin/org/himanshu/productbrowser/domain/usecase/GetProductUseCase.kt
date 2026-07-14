package org.himanshu.productbrowser.domain.usecase

import org.himanshu.productbrowser.domain.model.Product
import org.himanshu.productbrowser.domain.repository.ProductRepository

class GetProductUseCase (
    private val repository: ProductRepository
){
    suspend operator fun invoke(id: Int): Product{
        return repository.getProduct(id)
    }
}