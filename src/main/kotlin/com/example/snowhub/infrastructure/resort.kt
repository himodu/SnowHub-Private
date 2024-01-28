package com.example.snowhub.infrastructure

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "resorts")
class resort (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        // 리조트 이름
        @Column
        val resortName: String,

        // 타임별 영업시간
        @Column
        val dawnOpenTime: LocalDateTime? = null,
        @Column
        val dawnCloseTime: LocalDateTime? = null,
        @Column
        val dayOpenTime: LocalDateTime? = null,
        @Column
        val dayCloseTime: LocalDateTime? = null,
        @Column
        val nightOpenTime: LocalDateTime? = null,
        @Column
        val nightCloseTime: LocalDateTime? = null,
        @Column
        val midNightOpenTime: LocalDateTime? = null,
        @Column
        val midNightCloseTime: LocalDateTime? = null,

        @OneToMany(mappedBy = "resort")
        val slope: List<slope>? = null
)