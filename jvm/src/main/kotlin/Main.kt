import java.io.File

fun main(args: Array<String>) {
    val name = File("name.txt")
            .bufferedReader()
            .use { it.readLine() }
    println("Hello $name!")
}