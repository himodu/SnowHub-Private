package com.example.snowhub

import com.example.snowhub.infrastructure.resort
import com.example.snowhub.infrastructure.slope
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.ZoneId

@Component
class O2Crawler {
    fun crawling(){
        var result = mutableListOf<slope>()

        var date = LocalDate.now(ZoneId.of("Asia/Seoul"))

        var doc: Document = Jsoup.connect("https://www.o2resort.com/SKI/slopeOpen.jsp").get()

        var slopes = doc.select(".skiLeftBox tr")
        var opens = doc.select(".skiRightBox .slopeLV1" )

        var resort = resort(
                null,
                "YoungPyong"
        )

        var difficulty = ""
        var slopeName: String
        var day = ""
        var night = ""
        var dawn = ""


        for(i in 0 until 12){

            var tr = slopes.get(i+1).select("td")
            if(tr.size==7){
                difficulty = tr.get(0).text()
                slopeName = tr.get(2).text()
            }else{
                slopeName = tr.get(1).text()
            }

            var Otr = opens.get(i).select("td img")
            if(Otr.get(0).attr("src").equals("/common/images/ski/icon_slope_open.jpg")){
                day = "OPEN"
            }else{
                day = "CLOSE"
            }
            if(Otr.get(1).attr("src").equals("/common/images/ski/icon_slope_open.jpg")){
                night = "OPEN"
            }else{
                night = "CLOSE"
            }
            if(Otr.get(2).attr("src").equals("/common/images/ski/icon_slope_open.jpg")){
                dawn = "OPEN"
            }else{
                dawn = "CLOSE"
            }


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

            println(slopeName +" = "+day+", "+ night+", "+ dawn)

            result.add(slope)

        }

    }
}