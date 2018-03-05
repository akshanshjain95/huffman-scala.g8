package com.huffman

import org.scalatest.FunSuite

class HuffmanDecoderTest extends FunSuite {

  val huffmanDecoder = new HuffmanDecoder

  val testString = "This is a test string."
  val testStringCodeMap = Map("0001" -> "a", "100" -> "i", "110" -> " ", "0000" -> "g", "0011" -> "h", "0010" -> "r",
    "0111" -> ".", "111" -> "s", "0100" -> "n", "0110" -> "T", "101" -> "t", "0101" -> "e")

  val encodedString = "01100011100111110100111110000111010101011111011101111010010100010000000111"

  test("testDecode should return decoded string") {
    val resultDecodedString = huffmanDecoder.decode(encodedString, testStringCodeMap)

    assert(testString.equals(resultDecodedString))
  }

}
