package com.ice.tool.spring

interface BaseDao<T> {

    fun add(t: T)

    fun update(t: T)

    fun delete(t: T)

    fun queryById(id: Int): T?
}