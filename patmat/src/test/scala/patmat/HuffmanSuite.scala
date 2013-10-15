package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5)
    val t2 = Fork(Fork(Leaf('a', 2), Leaf('b', 3), List('a', 'b'), 5), Leaf('d', 4), List('a', 'b', 'd'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a', 'b', 'd'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("times(\"leonardo\")") {
    assert(times("leonardoloch".toList) === List(('e', 1), ('n', 1), ('a', 1), ('l', 2), ('c', 1), ('h', 1), ('r', 1), ('o', 3), ('d', 1)))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e', 1), Leaf('t', 2), List('e', 't'), 3), Leaf('x', 4)))
  }

  test("combine of a nil") {
    assert(combine(Nil) === Nil)
  }

  test("combine of a singleton") {
    val singletonList = List(Leaf('e', 1))
    assert(combine(singletonList) === List(Leaf('e', 1)))
  }

  test("until") {
    val leaflist = makeOrderedLeafList(List(('e', 1), ('t', 2), ('x', 4), ('k', 1)))
    assert(until(singleton, combine)(leaflist) === List(Fork(Fork(Fork(Leaf('e', 1), Leaf('k', 1), List('e', 'k'), 2), Leaf('t', 2), List('e', 'k', 't'), 4), Leaf('x', 4), List('e', 'k', 't', 'x'), 8)))
  }

  test("createCodeTree") {
    assert(createCodeTree("xetxtxkx".toList) === Fork(Fork(Fork(Leaf('e', 1), Leaf('k', 1), List('e', 'k'), 2), Leaf('t', 2), List('e', 'k', 't'), 4), Leaf('x', 4), List('e', 'k', 't', 'x'), 8))
  }

  test("decoded secret") {
    new TestTrees {
      assert(decodedSecret === "huffmanestcool".toList) //Huffman is cool
    }
  }

  test("decode") {
    new TestTrees {
      assert(decode(t2, List(0, 0, 0, 1, 1)) === "abd".toList)
    }
  }

  test("encode") {
    new TestTrees {
      assert(encode(t2)("bdaabdaabdaabdaabdaabdaabdaabdaa".toList) === List(0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0))
    }
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }

  test("convert t1") {
    new TestTrees {
      assert(convert(t1) === List(('a', List(0)), ('b', List(1))))
    }
  }

  test("convert t2") {
    new TestTrees {
      assert(convert(t2) === List(('a', List(0, 0)), ('b', List(0, 1)), ('d', List(1))))
    }
  }

  test("codebits t1") {
    new TestTrees {
      assert(codeBits(convert(t1))('a') === List(0))
    }
  }

  test("codebits t2") {
    new TestTrees {
      assert(codeBits(convert(t2))('b') === List(0, 1))
    }
  }

  test("quickEncode") {
    new TestTrees {
      assert(quickEncode(t2)("bdaabdaabdaabdaabdaabdaabdaabdaa".toList) === List(0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0))
    }
  }

  test("decode and quickEncode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
    }
  }
}
