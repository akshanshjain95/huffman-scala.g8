package com.huffman

object Boot extends App {

  val exampleString = "This is a test string."

  val huffmanEncoder = new HuffmanEncoder

  val huffmanDecoder = new HuffmanDecoder

  val codeMap = huffmanEncoder.codeMap(exampleString)

  val encodedString = huffmanEncoder.encode(exampleString)

  println("Encoded String --> " + encodedString)

  val decodedString = huffmanDecoder.decode(encodedString, codeMap)

  println("Decoded String --> " + decodedString)

  if(exampleString.equals(decodedString)) println("Huffman is working fine") else println("Something went wrong!")
}
