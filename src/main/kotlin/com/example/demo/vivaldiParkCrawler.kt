package com.example.demo

import com.example.demo.presenter.dto.response.slopeInfo
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.CloseableHttpClient
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.springframework.stereotype.Service
import java.net.http.HttpResponse

import java.util.Objects

@Service
class vivaldiParkCrawler {
    data class ApiResponse(val slopeNm:String, val slopeGrade:String, val dawnYn:String, val daytimeYn:String, val nightYn:String)

    fun crawling() {
        val httpClient: CloseableHttpClient = HttpClients.createDefault()

        try {
            val uri = "https://www.sonohotelsresorts.com/front.subMainAjax.getSlopeConditionAjax.dp/dmparse.dm"  // 여러 개의 데이터를 반환하는 엔드포인트로 가정
            val httpGet = HttpGet(uri)

            val response: org.apache.http.HttpResponse = httpClient.execute(httpGet)
            val entity = response.entity

            if (entity != null) {
                val content: String = EntityUtils.toString(entity)

                // JSON 문자열을 List<ApiResponse>로 역직렬화
                val jsonObject = Gson().fromJson(content, JsonObject::class.java)
                val listArray = jsonObject.getAsJsonArray("list")

                val apiResponseListType = object : TypeToken<List<ApiResponse>>() {}.type
                val slopeInfoList: List<ApiResponse> = Gson().fromJson(listArray, apiResponseListType)

                // 각 ApiResponse에 대한 작업 수행
                for (apiResponse in slopeInfoList) {
                    println("Name: ${apiResponse.slopeNm}")
                    println("Level: ${apiResponse.slopeGrade}")
                    println("dawn: ${apiResponse.dawnYn}")
                    println("day: ${apiResponse.daytimeYn}")
                    println("night: ${apiResponse.nightYn}")
                    // 추가로 필요한 속성들에 대한 처리
                    println("------")
                }
            }
        } finally {
            httpClient.close()
        }
    }
}