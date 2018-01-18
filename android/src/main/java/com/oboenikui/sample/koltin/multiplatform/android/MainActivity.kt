package com.oboenikui.sample.koltin.multiplatform.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.oboenikui.sample.kotlin.multiplatform.Fetch
import com.oboenikui.sample.kotlin.multiplatform.Method
import com.oboenikui.sample.kotlin.multiplatform.RequestInit
import kotlinx.coroutines.experimental.async

class MainActivity : AppCompatActivity() {
    val url = "https://gist.githubusercontent.com/oboenikui/b24c4d07fd74d2490b7ba69baa48f857/raw/103319544943e3e8e24e6088ef2df7a9eb381f2e/welcome.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        async {
            val response = Fetch.fetch(url, RequestInit(Method.GET)).await()
            val welcomeText = response.text().await()
            runOnUiThread {

            }
        }
    }
}
