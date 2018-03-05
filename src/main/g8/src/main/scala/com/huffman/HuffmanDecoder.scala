package com.huffman

class HuffmanDecoder {

  def decode(str: String, codeMap: Map[String, String]): String = {

    def constructDecodedString(stringToBeDecoded: String, code: Map[String, String], checkLength: Int, decodedString: String): String = {
      if (stringToBeDecoded.nonEmpty) {
        val codeToCheck = stringToBeDecoded.substring(0, checkLength)
        if (code.contains(codeToCheck)) {
          val newDecodedString = decodedString + code.getOrElse(codeToCheck, "")
          constructDecodedString(stringToBeDecoded.substring(checkLength, stringToBeDecoded.length), code, 1, newDecodedString)
        } else {
          constructDecodedString(stringToBeDecoded, code, checkLength + 1, decodedString)
        }
      } else {
        decodedString
      }
    }

    constructDecodedString(str, codeMap, 1, "")
  }
}
