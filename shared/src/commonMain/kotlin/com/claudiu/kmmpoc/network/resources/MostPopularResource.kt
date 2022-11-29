package com.claudiu.kmmpoc.network.resources

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("/svc/mostpopular/v2")
class MostPopular {

    @Serializable
    @Resource("/emailed")
    class Emailed(val parent: MostPopular = MostPopular()) {

        @Serializable
        @Resource("{period}")
        class Period(
            val period: String,
            val parent: Emailed = Emailed()
        )
    }

    @Serializable
    @Resource("/shared")
    class Shared(val parent: MostPopular = MostPopular()) {

        @Serializable
        @Resource("/{period}")
        class Period(
            val period: String,
            val parent: Shared = Shared()
        )
    }

    @Serializable
    @Resource("/viewed")
    class Viewed(val parent: MostPopular = MostPopular()) {

        @Serializable
        @Resource("/{period}")
        class Period(
            val period: String,
            val parent: Viewed = Viewed()
        )
    }
}

enum class MostPopularPeriod(val value: String) {
    DAY_1("1.json"),
    DAY_7("7.json"),
    DAY_30("30.json");
}