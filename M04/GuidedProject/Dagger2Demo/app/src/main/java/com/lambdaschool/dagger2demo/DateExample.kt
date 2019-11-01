package com.lambdaschool.dagger2demo

import java.util.*

object DateExample {
    private val date: Long = Date().time

    public fun getDate(): Long {
        return date
    }
}