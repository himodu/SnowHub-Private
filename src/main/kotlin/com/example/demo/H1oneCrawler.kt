package com.example.demo

import com.example.demo.presenter.dto.response.slopeInfo
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.springframework.stereotype.Service

@Service
class H1oneCrawler {
    fun crawling(): List<String>{
        var doc: Document = Jsoup.connect("https://www.high1.com/ski/slopeView.do?key=748&mode=p").get()
        var table: Elements = doc.select("tr")
        var result = mutableListOf<String>()


        if(table != null){
            for(row in table){
                result.add(row.text())
            }
        }else{
            println("not Found")
        }
        println(result)
        return result
    }
}