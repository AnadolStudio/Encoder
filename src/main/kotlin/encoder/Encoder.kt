package encoder

import alphabet.Alphabet

interface Encoder {

    fun encode(text: String): String

    fun decode(text: String): String


    abstract class Abstract(protected val alphabet: Alphabet) : Encoder

    abstract class Indexed(alphabet: Alphabet) : Abstract(alphabet) {

        protected val letterIndexMap = alphabet.letters
            .mapIndexed { i, v -> indexLetter(i) to v.uppercase() }
            .toMap()

        protected open val indexedLetterMap = alphabet.letters
            .mapIndexed { i, v -> v.uppercase() to indexLetter(i) }
            .toMap()

        protected open fun indexLetter(index: Int) = index
    }

    class Composite(var list: List<Encoder>) : Encoder {

        override fun encode(text: String): String = list.transformToString(text) { encoder, result ->
            encoder.encode(result)
        }

        override fun decode(text: String): String = list.reversed().transformToString(text) { encoder, result ->
            encoder.decode(result)
        }

    }

}
