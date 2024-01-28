package com.example.snowhub.presenter.dto.response

data class slopeInfo(
        val name: String,
        val level: String,

        val morningOpen: Boolean,
        val dayOpen: Boolean,
        val eveningOpen: Boolean,
        val midnightOpen: Boolean
)
