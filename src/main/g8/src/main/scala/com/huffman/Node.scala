package com.huffman

case class Node(char: String, frequency: Int, leftChild: Option[Node], rightChild: Option[Node], code: String) {

  def +(b: Node): Node = {
    val (leftChild, rightChild) = if (this.frequency >= b.frequency) (b, this) else (this, b)
    Node(this.char + b.char, this.frequency + b.frequency, Some(leftChild), Some(rightChild), "")
  }
}
