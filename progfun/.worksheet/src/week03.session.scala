package week03

object session {

  trait List[+T] {
    def head: T
    def tail: List[T]
    def isEmpty: Boolean
    def prepend[U >: T](elem: U): List[U] = new Cons(elem, this)
  }

  object Nil extends List[Nothing] {
    def head = throw new NoSuchElementException("head of EmptyList")
    def tail = throw new NoSuchElementException("tail of EmptyList")
    def isEmpty = true
  }

  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(514); 
  
  val x : List[String] = Nil;System.out.println("""x  : week03.session.List[String] = """ + $show(x ));$skip(50); 
  val y : List[String] = x prepend "first string";System.out.println("""y  : week03.session.List[String] = """ + $show(y ));$skip(51); 
  val z : List[String] = y prepend "second string";System.out.println("""z  : week03.session.List[String] = """ + $show(z ));$skip(9); val res$0 = 
  y.head;System.out.println("""res0: String = """ + $show(res$0));$skip(9); val res$1 = 
  z.head;System.out.println("""res1: String = """ + $show(res$1));$skip(14); val res$2 = 
  z.tail.head;System.out.println("""res2: String = """ + $show(res$2))}
}
