package com.claudiu.kmmpoc.network.models.topstories


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopStoriesResponse(
    @SerialName("copyright") val copyright: String,
    @SerialName("last_updated") val lastUpdated: String,
    @SerialName("num_results") val numResults: Int,
    @SerialName("results") val results: List<TopStoriesResult>,
    @SerialName("section") val section: String,
    @SerialName("status") val status: String
)