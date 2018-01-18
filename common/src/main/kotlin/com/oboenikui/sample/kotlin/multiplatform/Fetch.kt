package com.oboenikui.sample.kotlin.multiplatform

import kotlinx.coroutines.experimental.Deferred

expect object Fetch {
    fun fetch(url: String, init: RequestInit): Deferred<Response>
}

data class RequestInit(val method: Method = Method.GET, val body: String? = null)

enum class Method {
    GET,
    POST
}

expect open class Response {
    open val status: Short
    open val ok: Boolean
    open val statusText: String
    fun text(): Deferred<String>
}