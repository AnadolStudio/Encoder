package encoder.implementation

import alphabet.Alphabet
import encoder.Encoder

open class MirrorEncoder : Encoder.Abstract(Alphabet.Empty) {

    override fun encode(text: String): String = text.reversed()

    override fun decode(text: String): String = text.reversed()
}