package com.example.snowhub

import com.example.snowhub.infrastructure.resort
import com.example.snowhub.infrastructure.slope
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.ZoneId

@Component
class phyungChangCrawler {

    fun crawling() {
        var result = mutableListOf<slope>()

        var doc: Document = Jsoup.connect("https://phoenixhnr.co.kr/static/pyeongchang/snowpark/slope-lift").get()

        var date = LocalDate.now(ZoneId.of("Asia/Seoul"))

        var difficulty: String = ""
        var slopeName: String
        var day: String
        var night: String

        var resort = resort(
                null,
                "Pyeongchang"
        )

        var tbody: Elements = doc.select("tbody tr")
        var thElement: Elements
        var tdElement: Elements

        for (e in tbody) {

            thElement = e.select("th")
            if (thElement.size == 2) {
                difficulty = thElement.get(0).text()
                slopeName = thElement.get(1).text()
            } else {
                slopeName = thElement.get(0).text()
            }

            tdElement = e.select("td")
            day = tdElement.get(3).text()
            night = tdElement.get(4).text()

            var slope = slope(
                    null,
                    slopeName,
                    difficulty,
                    null,
                    day,
                    night,
                    null,
                    date,
                    resort
            )
            result.add(slope)
            println(day + "," + night)
        }

    }
}