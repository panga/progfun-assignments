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
    def balanceIter(count: Int, list: List[Char]): Boolean = {
      if (list.isEmpty) {
        count == 0
      } else if (list.head == '(') {
        balanceIter(count + 1, list.tail)
      } else if (list.head == ')') {
        if (count > 0) {
          balanceIter(count - 1, list.tail)
        } else {
          false
        }
      } else {
        balanceIter(count, list.tail)
      }
    }

    balanceIter(0, chars)
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
