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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(906); val res$0 = 

  Zero.successor + Zero.successor.successor.successor;System.out.println("""res0: week04.session.Nat = """ + $show(res$0));$skip(12); val res$1 = 
  
  List();System.out.println("""res1: List[Nothing] = """ + $show(res$1));$skip(14); val res$2 = 
  List(1,"2");System.out.println("""res2: List[Any] = """ + $show(res$2));$skip(12); val res$3 = 
  List(1,2);System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(16); val res$4 = 
  List("1","2");System.out.println("""res4: List[String] = """ + $show(res$4));$skip(25); val res$5 = 
  
  1 :: 2 :: List(3,4);System.out.println("""res5: List[Int] = """ + $show(res$5));$skip(26); val res$6 = 
  List(1,2) ::: List(3,4);System.out.println("""res6: List[Int] = """ + $show(res$6));$skip(21); val res$7 = 
  List().::(1).::(2);System.out.println("""res7: List[Int] = """ + $show(res$7));$skip(11); val res$8 = 
  1 :: Nil;System.out.println("""res8: List[Int] = """ + $show(res$8))}
}
