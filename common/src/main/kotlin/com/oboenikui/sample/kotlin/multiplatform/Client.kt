package com.oboenikui.sample.kotlin.multiplatform

import com.oboenikui.sample.kotlin.multiplatform.Fetch.fetch
import kotlinx.coroutines.experimental.async

object Client {
    fun getHello() = async {
        val helloResponse = fetch("http://localhost:8080/hello.txt", RequestInit()).await()
        helloResponse.text().await()
    }
}