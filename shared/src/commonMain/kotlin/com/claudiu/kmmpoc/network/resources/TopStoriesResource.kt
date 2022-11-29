package com.claudiu.kmmpoc.network.resources

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("/svc/topstories/v2")
class TopStories {

    @Serializable
    @Resource("/world.json")
    class World(val parent: TopStories = TopStories())

    @Serializable
    @Resource("/home.json")
    class Home(val parent: TopStories = TopStories())

    @Serializable
    @Resource("/science.json")
    class Science(val parent: TopStories = TopStories())

    @Serializable
    @Resource("/arts.json")
    class Arts(val parent: TopStories = TopStories())
}