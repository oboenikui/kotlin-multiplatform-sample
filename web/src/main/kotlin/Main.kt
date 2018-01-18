import com.oboenikui.sample.kotlin.multiplatform.Client
import com.oboenikui.sample.kotlin.multiplatform.Client.url
import com.oboenikui.sample.kotlin.multiplatform.Fetch.fetch
import com.oboenikui.sample.kotlin.multiplatform.RequestInit
import kotlinx.coroutines.experimental.async
import kotlin.browser.document
import kotlin.browser.window

fun main(args: Array<String>) {
    window.addEventListener("load", {
        async {
            val text = Client.getWelcome().await()
            val element = document.createElement("div")
                    .also { it.textContent = text }
            document.body?.appendChild(element)
            return@async
        }
    })
}