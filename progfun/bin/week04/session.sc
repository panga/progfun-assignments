package week04

object session {

  //Peano numbers
  abstract class Nat {
    def isZero: Boolean
    def predecessor: Nat
    def successor: Nat = new Succ(this)
    def +(that: Nat): Nat
    def -(that: Nat): Nat
    def numerical: Integer
    override def toString() = numerical.toString()
  }

  object Zero extends Nat {
    def isZero: Boolean = true
    def predecessor: Nat = throw new Error("negative number")
    def +(that: Nat): Nat = that
    def -(that: Nat): Nat = if (that.isZero) Zero else throw new Error("negative number")
    def numerical: Integer = 0
  }

  class Succ(n: Nat) extends Nat {
    def isZero: Boolean = false
    def predecessor: Nat = n
    def +(that: Nat): Nat = new Succ(n + that)
    def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor
    def numerical: Integer = n.numerical + 1
  }

  Zero.successor + Zero.successor.successor.successor
                                                  //> res0: week04.session.Nat = 4
  
  List()                                          //> res1: List[Nothing] = List()
  List(1,"2")                                     //> res2: List[Any] = List(1, 2)
  List(1,2)                                       //> res3: List[Int] = List(1, 2)
  List("1","2")                                   //> res4: List[String] = List(1, 2)
  
  1 :: 2 :: List(3,4)                             //> res5: List[Int] = List(1, 2, 3, 4)
  List(1,2) ::: List(3,4)                         //> res6: List[Int] = List(1, 2, 3, 4)
  List().::(1).::(2)                              //> res7: List[Int] = List(2, 1)
  1 :: Nil                                        //> res8: List[Int] = List(1)
}