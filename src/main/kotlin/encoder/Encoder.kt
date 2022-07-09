package encoder

import alpabet.Alphabet

interface Encoder {

    fun encode(text: String): String

    fun decode(text: String): String


    abstract class Abstract(protected val alphabet: Alphabet) : Encoder {

    }

    class Composite(var list: List<Encoder>) : Encoder {

        override fun encode(text: String): String = list.transformToString(text) { encoder, result ->
            encoder.encode(result)
        }

        override fun decode(text: String): String = list.transformToString(text) { encoder, result ->
            encoder.decode(result)
        }

    }

    class Digital(alphabet: Alphabet) : Abstract(alphabet) {
        protected val digitalMap = alphabet.letters.mapIndexed { i, v -> v to i }.toMap()

        override fun encode(text: String): String {
            TODO("Not yet implemented")
        }

        override fun decode(text: String): String {
            TODO("Not yet implemented")
        }
    }

    class Binary(alphabet: Alphabet) : Abstract(alphabet) {

        companion object{
            private const val BINARY_CODE_LENGTH = 16
            private const val BYTE_LENGTH = 8
        }


        override fun encode(text: String): String = text.toCharArray()
            .toList()
            .transformToString { char, result ->
                result + Integer.toBinaryString(char.code).let {
                    it.padStart(BINARY_CODE_LENGTH - it.length, '0')
                }
            }

        override fun decode(text: String): String {
            text.split("(?<=\\G.{16})".toRegex())
                .map { Integer.parseUnsignedInt(it, 1) } // TODO Need Test

            TODO()
        }
    }

    class Caesar(val step: Int, alphabet: Alphabet) : Abstract(alphabet) {

        override fun encode(text: String): String {
            TODO("Not yet implemented")
        }

        override fun decode(text: String): String {
            TODO("Not yet implemented")
        }
    }

    class Mirror() : Abstract(Alphabet.Empty()) {

        override fun encode(text: String): String = text.reversed()

        override fun decode(text: String): String = text.reversed()
    }

}
