package encoder.implementation

import alphabet.Alphabet
import encoder.Encoder

open class CaesarEncoder(private val step: Int, alphabet: Alphabet) : Encoder.Indexed(alphabet) {

    override fun encode(text: String): String = text.toCharArray().toList()
        .joinToString("") { char ->
            val currentIndex = indexedLetterMap[char.toString().uppercase()]
                ?: return@joinToString char.toString()
            val nextIndex = (currentIndex + step) % alphabet.size()

            correctCase(char, letterIndexMap[nextIndex])
                ?: return@joinToString char.toString()
        }

    override fun decode(text: String): String = text.toCharArray().toList()
        .joinToString("") { char ->
            val currentIndex = indexedLetterMap[char.toString().uppercase()] ?: return@joinToString char.toString()
            val previousIndex = ((currentIndex - step) % alphabet.size()).let {
                if (it >= 0) it else alphabet.size() + it
            }

            correctCase(char, letterIndexMap[previousIndex]) ?: return@joinToString char.toString()
        }

    private fun correctCase(letter: Char, text: String?): String? = when {
        text == null -> null
        letter.isLowerCase() -> text.lowercase()
        else -> text
    }
}