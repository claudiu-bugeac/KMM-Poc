package com.claudiu.kmmpoc.network

import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.plugins.resources.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

expect fun httpClient(): HttpClient

fun HttpClientConfig<*>.configure(
    host: String,
    urlProtocol: URLProtocol = URLProtocol.HTTPS,
    apiKey: String
) {
    install(Resources)
    addDefaultUrl(host, urlProtocol, apiKey)
    addLogging()
    addJsonContentNegotiation()
}

private fun HttpClientConfig<*>.addDefaultUrl(
    host: String,
    urlProtocol: URLProtocol,
    apiKey: String
) {

    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }

    defaultRequest {
        url {
            this.host = host
            this.protocol = urlProtocol
            this.parameters.append("api-key", apiKey)
        }
    }
}

private fun HttpClientConfig<*>.addLogging() {
    install(Logging) {
        logger = Logger.SIMPLE
        level = LogLevel.ALL
    }
}

private fun HttpClientConfig<*>.addJsonContentNegotiation() {
    install(ContentNegotiation) {
        json(
            Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }
        )
    }
}
