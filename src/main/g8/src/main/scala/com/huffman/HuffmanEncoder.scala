package com.huffman

import scala.annotation.tailrec

class HuffmanEncoder {

  def codeMap(str: String): Map[String, String] = {
    val list = str.groupBy(identity).mapValues(_.length).toList.map { case (char, count) => char.toString -> count }
    val listOfNodes: List[Node] = list.map(charWithCount => Node(charWithCount._1, charWithCount._2, None, None, "")).sortBy(_.frequency)

    @tailrec
    def huffmanTreeConstructor(listOfLeafNodes: List[Node]): Node = listOfLeafNodes match {
      case first :: second :: tail => huffmanTreeConstructor(((first + second) :: tail).sortBy(_.frequency))
      case head :: _               => head
      case Nil                     => throw new Exception("Cannot construct a codeMap for empty string")
    }

    @tailrec
    def huffmanCodeConstructor(listOfLeafNodes: List[Node], listOfNonLeafNodes: List[Node]): List[Node] = {
      if (listOfNonLeafNodes.nonEmpty) {
        (listOfNonLeafNodes.head.leftChild, listOfNonLeafNodes.head.rightChild) match {
          case (Some(leftChild), Some(rightChild)) => {
            val newLeftNode = leftChild.copy(code = listOfNonLeafNodes.head.code + "0")
            val newRightNode = rightChild.copy(code = listOfNonLeafNodes.head.code + "1")
            huffmanCodeConstructor(listOfLeafNodes, newLeftNode :: newRightNode :: listOfNonLeafNodes.tail)
          }
          case _                  => huffmanCodeConstructor(listOfNonLeafNodes.head :: listOfLeafNodes, listOfNonLeafNodes.tail)
        }
      } else {
        listOfLeafNodes
      }
    }

    huffmanCodeConstructor(Nil, List(huffmanTreeConstructor(listOfNodes))).map(node => node.code -> node.char).toMap
  }

  def encode(str: String): String = {

    val huffmanCodeMap = codeMap(str).map(_.swap)

    def constructEncodedString(stringToBeEncoded: String, huffmanCode: Map[String, String], encodedString: String): String = {
      if (stringToBeEncoded.nonEmpty) {
        val newEncodedString = encodedString + huffmanCode.getOrElse(stringToBeEncoded.substring(0, 1), "")
        constructEncodedString(stringToBeEncoded.substring(1, stringToBeEncoded.length), huffmanCode, newEncodedString)
      } else {
        encodedString
      }
    }

    constructEncodedString(str, huffmanCodeMap, "")
  }

}
