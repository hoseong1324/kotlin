package com.study.kotlin.user.repo

import com.study.kotlin.user.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long>{

    fun findByEmail(email : String) : User?
}