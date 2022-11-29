package com.claudiu.kmmpoc.network.models.mostpopular


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MediaMetadata(
    @SerialName("format") val format: String,
    @SerialName("height") val height: Int,
    @SerialName("url") val url: String,
    @SerialName("width") val width: Int
)