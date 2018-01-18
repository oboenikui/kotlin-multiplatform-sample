package com.oboenikui.sample.kotlin.multiplatform

import com.oboenikui.sample.kotlin.multiplatform.Fetch.fetch
import kotlinx.coroutines.experimental.async

object Client {

    val url = "https://gist.githubusercontent.com/oboenikui/b24c4d07fd74d2490b7ba69baa48f857/raw/103319544943e3e8e24e6088ef2df7a9eb381f2e/welcome.txt"
    fun getWelcome() = async {
        val helloResponse = fetch(url, RequestInit()).await()
        helloResponse.text().await()
    }
}