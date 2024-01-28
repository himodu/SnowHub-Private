package com.example.snowhub.presenter.controller


import com.example.snowhub.domain.service.resortService
import com.example.snowhub.presenter.dto.response.resortInfo
import com.example.snowhub.presenter.dto.response.resortList
import com.example.snowhub.H1oneCrawler
import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController()
@RequestMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
class resortController (
        private val H1oneCrawler: H1oneCrawler,
         private val resortService: resortService
){
    @GetMapping("/resorts")
    @Operation(summary = "리조트 목록조회", description = "모든 리조트를 조회합니다.")
    fun getResorts(): List<resortList>{
        return resortService.getResorts()
    }
    @GetMapping("/resorts/{resort_id}")
    @Operation(summary = "리조트 세부조회", description = "리조트의 세부정보를 조회합니다.")
    fun getResortsInfo(
            @PathVariable("resort_id") resortId: Int
    ): resortInfo{
        return resortService.getResortsInfo(resortId)
    }

//    @GetMapping("/resorts/{resort_id}/slopes")
//    @Operation(summary = "리조트 이용가능 슬로프 조회", description = "해당 리조트의 이용가능 슬로프를 조회합니다.")
//    fun getResortsSlopes(
//            @PathVariable("resort_id") resortId: Int
//    ): List<slopeInfo>{
//        return resortService.getResortsInfo(resortId)
//    }

    @GetMapping("/resorts/crawl")
    @Operation(summary = "하이원 리조트 슬로프 정보 크롤링", description = "하이원 리조트의 슬로프 정보를 텍스트 형태로 불러옵니다.")
    fun crawlingTest(
    ){
        resortService.getResortsSlopes()
    }

}