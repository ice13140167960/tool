package com.ice.tool.spring

interface BaseService<T> {

    fun add(t: T)

    fun delete(t: T)

    fun update(t: T)

    fun queryById(id: Int): T?
}