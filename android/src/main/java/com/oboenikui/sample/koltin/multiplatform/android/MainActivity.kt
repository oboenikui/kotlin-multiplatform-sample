package com.oboenikui.sample.koltin.multiplatform.android

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.oboenikui.sample.kotlin.multiplatform.Fetch.fetch
import com.oboenikui.sample.kotlin.multiplatform.Method
import com.oboenikui.sample.kotlin.multiplatform.RequestInit
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.async

class MainActivity : AppCompatActivity() {
    private val url = "https://gist.githubusercontent.com/oboenikui/b24c4d07fd74d2490b7ba69baa48f857/raw/103319544943e3e8e24e6088ef2df7a9eb381f2e/welcome.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        async {
            println("load start")
            val response = fetch(url, RequestInit(Method.GET)).await()
            println("decoding")
            val welcomeText = response.text().await()
            println("load end")
            runOnUiThread {
                progressBar.visibility = View.GONE
                textView.text = welcomeText
            }
        }
    }
}
