package com.study.kotlin.common.advice

import com.study.kotlin.common.enum.ResultCode
import com.study.kotlin.common.exception.InvalidInputException
import com.study.kotlin.common.response.CommonResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.validation.FieldError
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    protected fun methodArgumentNotValidException(ex: MethodArgumentNotValidException) : ResponseEntity<CommonResponse<Map<String,String>>>{
        val errors = mutableMapOf<String, String>()
        ex.bindingResult.allErrors.forEach{error ->
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage
            errors[fieldName] = errorMessage ?: "Not Exception Message"
        }
        return ResponseEntity(CommonResponse(ResultCode.ERROR.name, ResultCode.ERROR.msg, errors), HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(InvalidInputException::class)
    protected fun invalidInputException(ex : InvalidInputException) : ResponseEntity<CommonResponse<Map<String,String>>>{
        val errors = mapOf(ex.fieldName to (ex.message ?: "Not Exception Message"))
        return ResponseEntity(CommonResponse(ResultCode.ERROR.name, ResultCode.ERROR.msg, errors), HttpStatus.BAD_REQUEST)
    }

}