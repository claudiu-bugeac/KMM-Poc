package com.claudiu.kmmpoc.network

import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import java.util.concurrent.TimeUnit

actual fun httpClient(): HttpClient =
    HttpClient(OkHttp) {
        engine {
            config {
                retryOnConnectionFailure(false)
                connectTimeout(30, TimeUnit.SECONDS)
            }
        }
        configure(
            host = "api.nytimes.com",
            apiKey = "nBNfx1dobGHkLbABPG2AiayjKK9ziB3X"
        )
    }