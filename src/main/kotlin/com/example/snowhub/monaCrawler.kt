package com.example.snowhub

import com.example.snowhub.infrastructure.resort
import com.example.snowhub.infrastructure.slope
import com.example.snowhub.presenter.dto.response.slopeInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId

@Component
class monaCrawler {

    fun crawling(){
        var result = mutableListOf<slope>()

        var doc: Document = Jsoup.connect("https://www.yongpyong.co.kr/kor/skiNboard/slope/openStatusBoard.do").get()
        var tbody: Element = doc.select("tbody#slopeStatus").first()

        var date = LocalDate.now(ZoneId.of("Asia/Seoul"))

        var trElements: Elements = tbody.select("tr")

        var difficulty: String = ""
        var slopeName: String
        var day: String
        var night: String
        var dawn: String

        var slopeNameElement: Element
        var tdElements: Elements

        var resort = resort(
                null,
                "YoungPyong"
        )
        for(e in trElements){

            if(e.select("th").first() != null){
                difficulty = e.select("th").first().text()
            }

            if(e.select("td[class='']").first() != null){
                slopeNameElement= e.select("td.conLeft").first()
                slopeName = slopeNameElement.text()

                tdElements = e.select("td[class='']")

                day = tdElements.get(0).text()
                night = tdElements.get(1).text()
                dawn = tdElements.get(2).text()

                var slope = slope(
                        null,
                        slopeName,
                        difficulty,
                        null,
                        day,
                        night,
                        dawn,
                        date,
                        resort
                )
                result.add(slope)

            }
        }
    }
}