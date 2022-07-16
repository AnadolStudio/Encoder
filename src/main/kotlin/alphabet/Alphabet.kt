package alphabet

interface Alphabet {

    val letters: List<String>

    fun size() = letters.size


    class Base(override val letters: List<String>) : Alphabet

    object Empty : Alphabet {
        override val letters: List<String> = emptyList()
    }

}
