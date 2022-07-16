package encoder

import alphabet.Alphabet
import encoder.implementation.BinaryEncoder
import encoder.implementation.CaesarEncoder
import encoder.implementation.DigitalEncoder
import encoder.implementation.MirrorEncoder
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CompositeTest {
    companion object {
        private const val UPPERCASE_TEST_TEXT = "ABC"
        private const val LOWERCASE_TEST_TEXT = "abc"
        private const val DIFFERENT_CASE_TEST_TEXT = "Abc"
        private const val SENTENCE_TEST_TEXT = "abcab acba1bcb acbc1abcb. ac! bbcac"
    }

    private val alphabetLetter = Alphabet.Base(listOf("A", "B", "C"))
    private val alphabetDigit = Alphabet.Base(listOf("0", "1"))

    private val encoder = Encoder.Composite(
        listOf(
            CaesarEncoder(2, alphabetLetter),
            DigitalEncoder(alphabetLetter),
            BinaryEncoder(),
            BinaryEncoder(),
            CaesarEncoder(1, alphabetDigit),
            MirrorEncoder()
        )
    )

    private fun compositeCodeAndDecode(text: String): String = encoder.encode(text).let { encodeText ->
        encoder.decode(encodeText)
    }

    @Test
    fun `composite successful uppercase test`() {
        assertEquals(UPPERCASE_TEST_TEXT, compositeCodeAndDecode(UPPERCASE_TEST_TEXT))
    }

    @Test
    fun `composite successful lowercase test`() {
        assertEquals(LOWERCASE_TEST_TEXT, compositeCodeAndDecode(LOWERCASE_TEST_TEXT))
    }

    @Test
    fun `composite successful different case test`() {
        assertEquals(DIFFERENT_CASE_TEST_TEXT, compositeCodeAndDecode(DIFFERENT_CASE_TEST_TEXT))
    }

    @Test
    fun `composite successful sentence test`() {
        assertEquals(SENTENCE_TEST_TEXT, compositeCodeAndDecode(SENTENCE_TEST_TEXT))
    }

}
