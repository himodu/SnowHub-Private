package com.example.snowhub

import com.example.snowhub.infrastructure.resort
import com.example.snowhub.infrastructure.slope
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Component
import java.time.LocalDate
import java.time.ZoneId

@Component
class pyeungChangCrawler {

    fun crawling(){
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

        var table: Element = doc.select("table").first()
        var tbody: Elements = table.select("tbody tr")
        var thElement: Elements
        var tdElement: Elements
        var spanElement: Elements

        for (e in tbody) {
            day = ""
            night = ""

            thElement = e.select("th")
            if (thElement.size == 2) {
                difficulty = thElement.get(0).text()
                slopeName = thElement.get(1).text()
            } else {
                slopeName = thElement.get(0).text()
            }

            tdElement = e.select("td")
            spanElement = tdElement.get(3).select("span")
            for(span in spanElement){
                println(span.text())
                if(span.text()!=null){
                    day = "OPEN"
                }else{
                    day = "CLOSE"
                }
            }
            tdElement = e.select("td")
            spanElement = tdElement.get(4).select("span")
            for(span in spanElement){
                if(span.text()!=" "){
                    night = "OPEN"
                }else{
                    night = "CLOSE"
                }
            }

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
//            println(day+" , "+ night)
        }

    }
}