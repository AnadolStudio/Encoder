package alphabet

interface Alphabet {

    val letters: List<Char>

    fun size() = letters.size


    class Base(override val letters: List<Char>) : Alphabet

    object Empty : Alphabet {
        override val letters: List<Char> = emptyList()
    }

}
