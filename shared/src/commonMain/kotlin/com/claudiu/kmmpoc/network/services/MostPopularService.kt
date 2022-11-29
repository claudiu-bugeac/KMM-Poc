package com.claudiu.kmmpoc.network.services

import com.claudiu.kmmpoc.network.httpClient
import com.claudiu.kmmpoc.network.models.mostpopular.MostPopularResponse
import com.claudiu.kmmpoc.network.resources.MostPopular
import com.claudiu.kmmpoc.network.resources.MostPopularPeriod
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*

class MostPopularService(
    private val client: HttpClient = httpClient()
) : IMostPopularService {

    override suspend fun getMostEmailed(period: MostPopularPeriod): MostPopularResponse =
        client.get(MostPopular.Emailed.Period(period.value)).body()

    override suspend fun getMostShared(period: MostPopularPeriod): MostPopularResponse =
        client.get(MostPopular.Shared.Period(period.value)).body()

    override suspend fun getMostViewed(period: MostPopularPeriod): MostPopularResponse =
        client.get(MostPopular.Viewed.Period(period.value)).body()
}

interface IMostPopularService {

    suspend fun getMostEmailed(period: MostPopularPeriod): MostPopularResponse

    suspend fun getMostShared(period: MostPopularPeriod): MostPopularResponse

    suspend fun getMostViewed(period: MostPopularPeriod): MostPopularResponse
}