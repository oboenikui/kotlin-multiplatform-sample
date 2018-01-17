package com.oboenikui.sample.kotlin.multiplatform

import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.asDeferred
import kotlin.browser.window

actual object Fetch {
    actual fun fetch(url: String, init: RequestInit) =
            window.fetch(url, org.w3c.fetch.RequestInit(
                    method = init.method.name,
                    body = init.body
            )).then { Response(it) }.asDeferred()
}

actual open class Response(private val response: org.w3c.fetch.Response) {
    actual open val status = response.status
    actual open val ok = response.ok
    actual open val statusText: String = response.statusText
    actual fun text(): Deferred<String> {
        return response.text().asDeferred()
    }
}


