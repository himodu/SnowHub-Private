package com.example.demo

import com.example.demo.presenter.dto.response.slopeInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.springframework.stereotype.Service
import javax.swing.text.StyledEditorKit.BoldAction

@Service
class mujuCrawler {
    data class info(val slopeNm:String, val dawnYn:Boolean, val daytimeYn:Boolean, val afterNoonYn:Boolean, val nightYn:Boolean, val midNightYn:Boolean)

    fun crawling(){
        var doc: Document = Jsoup.connect("https://www.mdysresort.com/convert_main_slope_221207.asp").get()
        var table: Elements = doc.select(".course_list ul li")
        var result = mutableListOf<info>()


        if(table != null){
            for(row in table){

                var slopeNm: String = row.select("p").text()
                if(slopeNm == ""){
                    continue
                }

                var dawnOp: Boolean
                var dayOp: Boolean
                var afterOp: Boolean
                var nightOp: Boolean
                var midNightOp: Boolean

                var openList:Elements = row.select("ul li")


                if(openList.get(0).attr("class")=="on"){
                    println("sex")
                    dawnOp = true
                }else{
                    dawnOp = false
                }
                if(openList.get(1).attr("class")=="on"){
                    dayOp = true
                }else{
                    dayOp = false
                }
                if(openList.get(2).attr("class")=="on"){
                    afterOp = true
                }else{
                    afterOp = false
                }
                if(openList.get(3).attr("class")=="on"){
                    nightOp = true
                }else{
                    nightOp = false
                }
                if(openList.get(4).attr("class")=="on"){
                     midNightOp= true
                }else{
                    midNightOp = false
                }

                var newSlope = info(
                        slopeNm = slopeNm,
                        dawnYn = dawnOp,
                        daytimeYn = dayOp,
                        afterNoonYn = afterOp,
                        nightYn = nightOp,
                        midNightYn = midNightOp
                )
                result.add(newSlope)
            }
        }else{
            println("not Found")
        }
        println(result)
    }
}