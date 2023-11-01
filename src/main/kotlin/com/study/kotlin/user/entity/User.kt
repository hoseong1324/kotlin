package com.study.kotlin.user.entity

import com.study.kotlin.common.entity.DateEntity
import com.study.kotlin.user.enum.Gender
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Long? = null,

        @Column(nullable = false, updatable = false)
        val email : String,

        @Column(nullable = false, length = 100)
        var password : String,

        @Column(nullable = false, length = 10)
        var name : String,

        @Column(nullable = false)
        @Enumerated(EnumType.STRING)
        var gender : Gender,

        @Column(nullable = false)
        @Temporal(TemporalType.DATE)
        var birthDate : LocalDate

): DateEntity()