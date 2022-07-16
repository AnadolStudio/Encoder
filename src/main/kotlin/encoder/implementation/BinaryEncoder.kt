package encoder.implementation

import alphabet.Alphabet
import encoder.Encoder
import encoder.connectToString

open class BinaryEncoder : Encoder.Abstract(Alphabet.Empty) {

    private companion object {
        const val BINARY_CODE_LENGTH = 16
        val BINARY_PATTERN = "(?<=\\G.{16})".toRegex()
    }

    override fun encode(text: String): String = text.toCharArray().toList()
        .connectToString { char -> Integer.toBinaryString(char.code).padStart(BINARY_CODE_LENGTH, '0') }

    override fun decode(text: String): String = text.split(BINARY_PATTERN, text.length / BINARY_CODE_LENGTH)
        .map { codeString -> Integer.parseUnsignedInt(codeString, Character.MIN_RADIX) }
        .joinToString("") { codeChar -> Char(codeChar).toString() }
}