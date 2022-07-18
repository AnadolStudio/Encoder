package encoder

inline fun <R> CharArray.mapWithPreviousResult(transform: (previousChar: R?, currentChar: Char) -> R): List<R> {
    val destination = mutableListOf<R>()

    for ((index, item) in this.withIndex()) {
        val previousChar = if (index > 0) destination[index - 1] else null
        destination.add(transform(previousChar, item))
    }

    return destination
}

fun <T> List<T>.connectToString(block: ((T) -> String)? = null): String {
    var result = ""

    this.forEach {
        result += block?.invoke(it) ?: it
    }

    return result
}

fun CharSequence.wrap(regex: Regex, start: CharSequence, end: CharSequence): String =
    regex.replace(this) { matcherResult -> "$start${matcherResult.groupValues[1]}$end" }

fun CharSequence.unwrap(regex: Regex = "(.*)".toRegex(), start: CharSequence, end: CharSequence): String =
    "$start($regex)$end".toRegex().replace(this) { matcherResult -> matcherResult.groupValues[1] }

fun <T> List<T>.transformToString(startValue: String, block: (T, String) -> String): String {
    var result = startValue

    this.forEach {
        result = block(it, result)
    }

    return result
}