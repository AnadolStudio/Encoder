package encoder

fun <T> List<T>.transformToString(block: (T, String) -> String): String = this.transformToString("", block)

fun <T> List<T>.transformToString(startValue: String, block: (T, String) -> String): String {
    var result = startValue

    this.forEach {
        result = block(it, result)
    }

    return result
}