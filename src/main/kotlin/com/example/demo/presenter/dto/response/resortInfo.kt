package com.example.demo.presenter.dto.response

import java.time.LocalDate
import java.util.Date

data class resortInfo(
        val resortName: String,
        val address: String,

        val openDate: LocalDate,
        val closeDate: LocalDate,

        val webcamList: List<String>,
        val eventList: List<Map<String, LocalDate>>,

)
