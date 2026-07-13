package org.himanshu.productbrowser.core.network

import io.ktor.client.HttpClient
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

object HttpClientFactory{

    fun create(): HttpClient{
        return HttpClient{

            defaultRequest {
                url(NetworkConstants.BASE_URL)
            }

            install(ContentNegotiation){
                json(
                    Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                        isLenient = true
                        explicitNulls = false
                    }
                )
            }
        }
    }
}