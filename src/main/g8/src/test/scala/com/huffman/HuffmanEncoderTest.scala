package com.huffman

import org.scalatest.FunSuite

class HuffmanEncoderTest extends FunSuite {

  val huffmanEncoder = new HuffmanEncoder

  val testString = "This is a test string."
  val testStringCodeMap = Map("0001" -> "a", "100" -> "i", "110" -> " ", "0000" -> "g", "0011" -> "h", "0010" -> "r",
    "0111" -> ".", "111" -> "s", "0100" -> "n", "0110" -> "T", "101" -> "t", "0101" -> "e")

  val encodedString = "01100011100111110100111110000111010101011111011101111010010100010000000111"

  test("codeMap function should return testStringCodeMap for testString") {
    val resultCodeMap = huffmanEncoder.codeMap(testString)

    assert(resultCodeMap.keySet.forall(testStringCodeMap.keySet))
  }

  test("encode function should return encoded string for the given string") {
    val resultEncodedString = huffmanEncoder.encode(testString)

    assert(encodedString.equals(resultEncodedString))
  }

}
