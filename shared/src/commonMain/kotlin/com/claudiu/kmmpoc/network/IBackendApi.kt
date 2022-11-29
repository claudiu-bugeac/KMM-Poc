package com.claudiu.kmmpoc.network

import com.claudiu.kmmpoc.network.services.IMostPopularService
import com.claudiu.kmmpoc.network.services.ITopStoriesService

interface IBackendApi : ITopStoriesService, IMostPopularService