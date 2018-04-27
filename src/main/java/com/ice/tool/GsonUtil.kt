package com.ice.tool

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

/**
 * Gson封装
 */
@Suppress("unused")
object GsonUtil {
    private val gson = Gson()

    /**
     * 对象转json字符串
     */
    fun toJson(any: Any): String = gson.toJson(any)

    /**
     * json字符串转对象
     */
    fun <T> fromJson(string: String, c: Class<T>): T = gson.fromJson(string, c)

    /**
     * json字符串转数组
     */
    fun <T> fromJson2Array(string: String,c:Class<T>): List<T> = gson.fromJson(string, object : TypeToken<List<T>>() {}.type)
}