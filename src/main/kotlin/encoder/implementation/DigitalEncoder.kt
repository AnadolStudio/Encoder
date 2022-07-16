package encoder.implementation

import alphabet.Alphabet
import encoder.*

open class DigitalEncoder(alphabet: Alphabet) : Encoder.Indexed(alphabet) {

    private companion object {
        const val DOT = "."
        const val DASH = "-"
        const val SPACE = " "
        val DIGIT = "\\d".toRegex()
        val DIGIT_PATTERN = "(\\d+)([.]?)".toRegex()
    }

    override fun indexLetter(index: Int): Int = index + 1

    override fun encode(text: String): String = text
        .wrap("([$DASH$DOT$DIGIT])".toRegex(), "{", "}")
        .split(SPACE)
        .joinToString(SPACE) { word ->
            word.toCharArray().mapWithPreviousResult<String> { previous, char ->
                val letter = char.toString()
                var result = indexedLetterMap[letter.uppercase()]
                    ?.toString()
                    ?: return@mapWithPreviousResult letter

                if (previous.isDigitalCode()) { // add DASH
                    result = DASH + result
                }

                if (char.isUpperCase()) { // add DOT
                    result += DOT
                }

                return@mapWithPreviousResult result
            }.connectToString()
        }

    override fun decode(text: String): String = text.split(SPACE)
        .joinToString(SPACE) { word ->
            //([\d.])?-([\d.]) После первого совпадения первая группа не попадает в расчет, поэтому там ?
            word.replace("($DIGIT_PATTERN)?-$DIGIT_PATTERN".toRegex()) { matchResult -> // Разбивает группу
                val first = if (matchResult.groupValues[1].isNotEmpty()) {
                    getLetterFromIndex(matchResult.groupValues[2], matchResult.groupValues[3])
                } else {
                    ""
                }
                val second = getLetterFromIndex(matchResult.groupValues[4], matchResult.groupValues[5])

                return@replace "${first}${second}"
            }.replace("[^{]$DIGIT_PATTERN[^}]".toRegex()) { matchResult -> // разбивает одиночек
                getLetterFromIndex(matchResult.groupValues[1], matchResult.groupValues[2])
            }.replace("^$DIGIT_PATTERN$".toRegex()) { matchResult -> // Если строка из одного символа
                getLetterFromIndex(matchResult.groupValues[1], matchResult.groupValues[2])
            }
        }
        .unwrap("[$DIGIT$DOT$DASH]*".toRegex(), "\\{", "}") // { - исполняемый символ потому \\{

    private fun getLetterFromIndex(index: String, dot: String): String =
        if (index.isEmpty()) ""
        else requireNotNull(letterIndexMap[index.toInt()]).run {
            when {
                dot.isEmpty() -> lowercase()
                else -> this
            }
        }

    private fun String?.isDigitalCode(): Boolean = this != null && (toIntOrNull() != null || last().toString() == DOT)
}