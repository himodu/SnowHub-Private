package com.example.demo.presenter.dto.response

import java.util.Date

data class slopeInfo(
        val name: String,
        val level: String,



        val morningOpen: Boolean,
        val dayOpen: Boolean,
        val eveningOpen: Boolean,
        val midnightOpen: Boolean
)
