package com.study.kotlin.user.service

import com.study.kotlin.user.dto.SignUpDto
import com.study.kotlin.user.entity.User
import com.study.kotlin.user.repo.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(private val userRepository: UserRepository) {
    /**
     * 회원가입
     */
    fun signUp(signUpRequestDto: SignUpDto) : String {
        var user: User? = userRepository.findByEmail(signUpRequestDto.email)

        if (user != null) {
            return "이미 등록된 이메일입니다"
        }

        user = User(
                null,
                signUpRequestDto.email,
                signUpRequestDto.password,
                signUpRequestDto.name,
                signUpRequestDto.gender,
                signUpRequestDto.birthDate
        )

        userRepository.save(user)
        return "회원가입이 완료되었습니다."
    }
}