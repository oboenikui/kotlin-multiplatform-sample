import kotlinx.coroutines.experimental.runBlocking

fun main(args: Array<String>) {
    Fetch.apply {
        runBlocking {
            val response = fetch("http://example.com", RequestInit(Method.GET)).await()
            val html = response.text().await()
            println(html)
        }
    }
}