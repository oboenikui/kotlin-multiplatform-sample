package com.oboenikui.sample.kotlin.multiplatform

import kotlinx.coroutines.experimental.async
import kotlin.test.Test
import kotlin.test.assertTrue

class FetchTest {
    @Test fun testFetch() {
        Fetch.apply {
            async {
                val response = fetch("http://example.com", RequestInit(Method.GET)).await()
                val html = response.text().await()
                assertTrue { html.isNotEmpty() }
                assertTrue { html.startsWith("<!doctype html>") }
            }
        }
    }
}