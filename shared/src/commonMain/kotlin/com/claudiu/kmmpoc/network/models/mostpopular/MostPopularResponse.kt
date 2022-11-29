package com.claudiu.kmmpoc.network.models.mostpopular


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MostPopularResponse(
    @SerialName("copyright") val copyright: String,
    @SerialName("num_results") val numResults: Int,
    @SerialName("results") val results: List<MostPopularResult>,
    @SerialName("status") val status: String
)