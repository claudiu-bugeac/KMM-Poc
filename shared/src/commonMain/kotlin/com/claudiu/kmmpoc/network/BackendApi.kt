package com.claudiu.kmmpoc.network

import com.claudiu.kmmpoc.network.models.mostpopular.MostPopularResponse
import com.claudiu.kmmpoc.network.models.topstories.TopStoriesResponse
import com.claudiu.kmmpoc.network.resources.MostPopularPeriod
import com.claudiu.kmmpoc.network.services.MostPopularService
import com.claudiu.kmmpoc.network.services.TopStoriesService

class BackendApi: IBackendApi {

    private val topStoriesService: TopStoriesService = TopStoriesService()
    private val mostPopularService: MostPopularService = MostPopularService()

    override suspend fun getWorldTopStories(): TopStoriesResponse =
        topStoriesService.getWorldTopStories()

    override suspend fun getHomeTopStories(): TopStoriesResponse =
        topStoriesService.getHomeTopStories()

    override suspend fun getScienceTopStories(): TopStoriesResponse =
        topStoriesService.getScienceTopStories()

    override suspend fun getArtsTopStories(): TopStoriesResponse =
        topStoriesService.getArtsTopStories()

    override suspend fun getMostEmailed(period: MostPopularPeriod): MostPopularResponse =
        mostPopularService.getMostEmailed(period)

    override suspend fun getMostShared(period: MostPopularPeriod): MostPopularResponse =
        mostPopularService.getMostEmailed(period)

    override suspend fun getMostViewed(period: MostPopularPeriod): MostPopularResponse =
        mostPopularService.getMostEmailed(period)
}