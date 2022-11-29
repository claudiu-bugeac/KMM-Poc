package com.claudiu.kmmpoc.network.services

import com.claudiu.kmmpoc.network.httpClient
import com.claudiu.kmmpoc.network.models.topstories.TopStoriesResponse
import com.claudiu.kmmpoc.network.resources.TopStories
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.resources.*

class TopStoriesService(
    private val client: HttpClient = httpClient()
) : ITopStoriesService {

    override suspend fun getWorldTopStories(): TopStoriesResponse =
        client.get(TopStories.World()).body()

    override suspend fun getHomeTopStories(): TopStoriesResponse =
        client.get(TopStories.Home()).body()

    override suspend fun getScienceTopStories(): TopStoriesResponse =
        client.get(TopStories.Science()).body()

    override suspend fun getArtsTopStories(): TopStoriesResponse =
        client.get(TopStories.Arts()).body()
}

interface ITopStoriesService {

    suspend fun getWorldTopStories(): TopStoriesResponse

    suspend fun getHomeTopStories(): TopStoriesResponse

    suspend fun getScienceTopStories(): TopStoriesResponse

    suspend fun getArtsTopStories(): TopStoriesResponse
}