package com.example.snowhub

import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class H1oneCrawler {
    data class info(val slopeNm:String, val daytimeYn:Boolean, val nightYn:Boolean )

    fun crawling(){
        var doc: Document = Jsoup.connect("https://www.high1.com/ski/slopeView.do?key=748&mode=p").get()
        var table: Elements = doc.select("tr td")
        var result = mutableListOf<info>()

        var index = 0
        var slopeBaseName=""
        var slopeRealName=""
        var dayOp = false
        var nightOp = false

        if(table != null){
            for(row in table){

                if(row.attr("rowspan")!=""){
                    index = 0
                    slopeBaseName = row.text()
                }
                if(row.text()==""){
                    index = 0

                    var newSlope = info(
                            slopeNm = slopeRealName,
                            daytimeYn = dayOp,
                            nightYn = nightOp
                    )
                    result.add(newSlope)
                }
                if(index == 1){
                    slopeRealName = slopeBaseName + row.text()
                }
                if(index == 2){
                    if(row.select("span").text()=="OPEN"){
                        dayOp = true
                    }else{
                        dayOp = false
                    }
                }
                if(index == 3){
                    if(row.select("span").text()=="OPEN"){
                        nightOp = true
                    }else{
                        nightOp = false
                    }
                }
                index += 1
            }
        }else{
            println("not Found")
        }
        println(result)
    }
}