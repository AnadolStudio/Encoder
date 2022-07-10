package encoder

sealed class EncoderException(override val message: String?) : Exception()

class AlphabetLetterException(letter: String) : Exception("Letter \"$letter\" not exist in alphabet")
