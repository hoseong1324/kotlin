package com.study.kotlin.common.response

import com.study.kotlin.common.enum.ResultCode

data class CommonResponse<T>(
        val resultCode : String = ResultCode.SUCCESS.name,
        val message : String = ResultCode.SUCCESS.msg,
        val data : T? = null
)