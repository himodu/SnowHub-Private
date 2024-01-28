package com.example.snowhub.infrastructure

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "slopes")
class slope (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

        @Column
        val slopeName: String,
        @Column
        val level: String,

        @Column
        val dawn: String? = null,
        @Column
        val day: String? = null,
        @Column
        val night: String? = null,
        @Column
        val midnight: String? = null,

        @Column
        val date: LocalDate? = null,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "resortId")
        val resort: resort
)