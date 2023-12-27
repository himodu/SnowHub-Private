package com.example.demo

import com.example.demo.presenter.dto.response.slopeInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class monaCrawler {

    fun crawling(): List<slopeInfo>{
        var doc: Document = Jsoup.connect("https://www.yongpyong.co.kr/kor/skiNboard/slope/openStatusBoard.do").get()
        var table: Elements = doc.select("#slopeStatus tr")
        var result = mutableListOf<slopeInfo>()

        var dayOpen: Boolean
        var nightOpen: Boolean
        var midNightOpen: Boolean
//
//        if(table != null){
//            for(row in table){
//                var tabletd: Elements = doc.select("td")
//
//                var dayOp: Element = tabletd.get(2)
//                var nigOp: Element = tabletd.get(3)
//                var midOp: Element = tabletd.get(4)
//
//                if(dayOp.attr("alt")=="OPEN"){
//                    dayOpen = true
//                }else{
//                    dayOpen = false
//                }
//
//                if(nigOp.attr("alt")=="OPEN"){
//                    nightOpen = true
//                }else{
//                    nightOpen = false
//                }
//
//                if(midOp.attr("alt")=="OPEN"){
//                    midNightOpen = true
//                }else{
//                    midNightOpen = false
//                }
//
//                var slope = slopeInfo(
//                        tabletd.get(0).text(),
//                        tabletd.get(1).text(),
//                        true,
//                        dayOpen,
//                        nightOpen,
//                        midNightOpen
//                )
//                result.add(slope)
//
//            }
//        }else{
//            println("not Found")
//        }
        println(table.html())
        return result
    }
}