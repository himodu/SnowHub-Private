package com.example.demo.application.service

import com.example.demo.H1oneCrawler
import com.example.demo.monaCrawler
import com.example.demo.mujuCrawler
import com.example.demo.presenter.dto.response.resortInfo
import com.example.demo.presenter.dto.response.resortList
import com.example.demo.presenter.dto.response.slopeInfo
import com.example.demo.vivaldiParkCrawler
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@Service
class resortService(
        private  val H1oneCralwer: H1oneCrawler,
        private val vivaldiParkCrawler: vivaldiParkCrawler,
        private val monaCrawler: monaCrawler,
        private val mujuCrawler: mujuCrawler
) {
    fun getResorts() : List<resortList>{

        var list = mutableListOf<resortList>()

        list.add(resortList("하이원리조트"))
        list.add(resortList("A리조트"))
        list.add(resortList("B리트"))
        println(list)
        return list
    }

    fun getResortsInfo(
            resortId: Int
    ) : resortInfo{
        val openDate: LocalDate = LocalDate.parse("2023-01-01", DateTimeFormatter.ISO_DATE)
        val closeDate: LocalDate = LocalDate.parse("2023-03-03", DateTimeFormatter.ISO_DATE)
        val eventDate: LocalDate = LocalDate.parse("2023-02-02", DateTimeFormatter.ISO_DATE)

        val webcamList = mutableListOf<String>()
        webcamList.add("1번 웹캠 url")
        webcamList.add("2번 웹캠 url")

        val eventList = mutableListOf<Map<String, LocalDate>>()

        val event = mapOf<String,LocalDate>("할인 이벤트" to eventDate)

        eventList.add(event)

        val info = resortInfo(
                "하이원리조트",
                "강원도",
                 openDate,
                closeDate,
                webcamList,
                eventList
                )

        return info
    }

    fun getResortsSlopes(
            resortId: Int
    ) {
        H1oneCralwer.crawling()
    }
}