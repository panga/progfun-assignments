package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def balanceIter(open: Int, close: Int, token: Char, list: List[Char]): Boolean = {
      if (token == '(') {
        if (list.isEmpty) {
          close == open + 1
        } else {
          balanceIter(open + 1, close, list.head, list.tail)
        }
      } else if (token == ')') {
        if (list.isEmpty) {
          open == close + 1
        } else {
          if (open > close) {
            balanceIter(open, close + 1, list.head, list.tail)
          } else {
            false
          }
        }
      } else if (!list.isEmpty) {
        balanceIter(open, close, list.head, list.tail)
      } else {
        (open == close)
      }
    }

    if (chars.isEmpty) {
      true
    } else {
      balanceIter(0, 0, chars.head, chars.tail)
    }

  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else if (money < 0) 0
    else if (money == 0) 1
    else countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }

}
