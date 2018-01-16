import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody

actual object Fetch {
    private val client = OkHttpClient()
    actual fun fetch(url: String, init: RequestInit): Deferred<Response> = async {
        val request = Request.Builder()
                .url(url)
                .method(init.method.name, init.body?.let {
                    RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), it)
                })
                .build()
        Response(client.newCall(request).execute())
    }
}

open actual class Response(val response: okhttp3.Response) {
    actual open val status = response.code().toShort()
    actual open val ok = response.isSuccessful
    actual open val statusText: String = response.message()
    actual fun text(): Deferred<String> = async {
        response.body()?.string() ?: ""
    }
}