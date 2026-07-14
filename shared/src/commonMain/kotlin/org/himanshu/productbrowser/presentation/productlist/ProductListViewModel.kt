package org.himanshu.productbrowser.presentation.productlist

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.himanshu.productbrowser.core.presentation.BaseViewModel
import org.himanshu.productbrowser.domain.usecase.GetProductsUseCase
import org.himanshu.productbrowser.domain.usecase.SearchProductsUseCase

class ProductListViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val searchProductsUseCase: SearchProductsUseCase
): BaseViewModel(){

    private val _state = MutableStateFlow(ProductListState())

    val state: StateFlow<ProductListState> = _state.asStateFlow()

    init {
        onEvent(ProductListEvent.LoadProducts)
    }

    fun onEvent(event: ProductListEvent){
        when(event){
            ProductListEvent.LoadProducts -> fetchProducts()
            is ProductListEvent.Search -> searchProduct(event.query)
            is ProductListEvent.ProductClicked -> {
                //Navigation handled
            }
        }
    }

    private fun searchProduct(query: String) {
        if(query.isBlank()){
            fetchProducts()
            return
        }

        launch {
            updateState {
                copy(
                    isLoading = true,
                    searchQuery = query
                )
            }

            runCatching {
                searchProductsUseCase(query)
            }.onSuccess { products ->

                updateState {
                    copy(
                        isLoading = false,
                        products = products
                    )
                }
            }.onFailure { exception ->
                updateState {
                    copy(
                        isLoading = false,
                        error = exception.message ?: "Something went wrong..,"
                    )
                }
            }
        }
    }

    private fun fetchProducts() {
        launch {
          updateState {
              copy(
                  isLoading = true
              )
          }

            runCatching {
                getProductsUseCase()
            }.onSuccess { products ->
                updateState {
                    copy(
                        isLoading = false,
                        products = products
                    )
                }
            }.onFailure { exception ->
                updateState {
                    copy(
                        isLoading = false,
                        error = exception.message ?: "Something went wrong"
                    )
                }
            }
        }
    }

    private fun updateState(
        reducer: ProductListState.()-> ProductListState
    ){
        _state.value = _state.value.reducer()
    }
}