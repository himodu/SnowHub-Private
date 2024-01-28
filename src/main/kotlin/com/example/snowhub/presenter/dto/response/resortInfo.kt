package com.example.snowhub.presenter.dto.response

import java.time.LocalDate

data class resortInfo(
        val resortName: String,
        val address: String,

        val openDate: LocalDate,
        val closeDate: LocalDate,

        val webcamList: List<String>,
        val eventList: List<Map<String, LocalDate>>,

)
