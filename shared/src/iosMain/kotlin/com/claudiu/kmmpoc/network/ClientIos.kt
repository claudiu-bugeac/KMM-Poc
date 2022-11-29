package com.claudiu.kmmpoc.network

import io.ktor.client.*
import io.ktor.client.engine.darwin.*

actual fun httpClient(): HttpClient =
    HttpClient(Darwin) {
        engine {
            configureRequest {
                setAllowsCellularAccess(true)
            }
        }
        configure(
            host = "api.nytimes.com",
            apiKey = "nBNfx1dobGHkLbABPG2AiayjKK9ziB3X"
        )
    }