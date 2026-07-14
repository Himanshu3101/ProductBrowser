package org.himanshu.productbrowser.domain.usecase

import kotlinx.coroutines.test.runTest
import org.himanshu.productbrowser.domain.model.Product
import org.himanshu.productbrowser.domain.repository.ProductRepository
import kotlin.test.Test
import kotlin.test.assertEquals

class GetProductsUseCaseTest{

    @Test
    fun `should return products from repository`() = runTest {
        //Arrange
        val repository = FakeProductRepository()
        val useCase = GetProductsUseCase(repository)

        //Act
        val result = useCase()

        //Assert
        assertEquals(1, result.size)
        assertEquals("iPhone 15", result.first().title)
        assertEquals(999.99, result.first().price)
    }


}

private class FakeProductRepository: ProductRepository{
    override suspend fun getProducts(): List<Product> {
        return listOf(
            Product(
                id = 1,
                title = "iPhone 15",
                description = "Latest iPhone",
                brand = "Apple",
                price = 999.99,
                rating = 4.8,
                thumbnail = "",
                category = "smartphones"
            )
        )
    }

    override suspend fun getProduct(id: Int): Product {
        return getProducts().first()
    }

    override suspend fun searchProduct(query: String): List<Product> {
        return getProducts()
    }

}