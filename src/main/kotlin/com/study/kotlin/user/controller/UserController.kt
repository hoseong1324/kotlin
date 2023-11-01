package com.study.kotlin.user.controller

import com.study.kotlin.user.dto.SignUpDto
import com.study.kotlin.user.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController (
        private val signUpService : UserService
){
    /**
     * 회원가입
     */
    @PostMapping("/sign-up")
    fun userSignUp(@RequestBody signUpRequestDto : SignUpDto) : String {
        return signUpService.signUp(signUpRequestDto)
    }
}