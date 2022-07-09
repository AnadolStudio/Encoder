package alpabet

interface Alphabet {

    val letters: List<String>


    class Base(override val letters: List<String>) : Alphabet

    class Empty : Alphabet{
        override val letters: List<String> = emptyList()
    }

}
