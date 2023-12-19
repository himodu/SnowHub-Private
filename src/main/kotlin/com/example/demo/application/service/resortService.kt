package com.example.demo.application.service

import com.example.demo.presenter.dto.response.resortInfo
import com.example.demo.presenter.dto.response.resortList
import com.example.demo.presenter.dto.response.slopeInfo
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date

@Service
class resortService() {
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
    ) : List<slopeInfo>{



        val slopeAll = mutableListOf<slopeInfo>()
        val slopeOpen = mutableListOf<slopeInfo>()
        val slope1 = slopeInfo(
                "아테나",
                "초급",
                true,
                true,
                true,
                false
        )
        val slope2 = slopeInfo(
                "그리스",
                "중급",
                true,
                true,
                false,
                false
        )
        val slope3 = slopeInfo(
                "로마",
                "고급",
                true,
                true,
                true,
                false
        )


        slopeAll.add(slope1)
        slopeAll.add(slope2)
        slopeAll.add(slope3)

        for(x in slopeAll){
            if(x.dayOpen){
                slopeOpen.add(x)
            }
        }
        return slopeOpen
    }
}