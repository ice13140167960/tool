package com.ice.tool

data class Result<T>(var code: Int = 0, var msg: String = "", var data: T)
