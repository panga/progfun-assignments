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
  }
  
  val x : List[String] = Nil                      //> x  : week03.session.List[String] = week03.session$Nil$@d1dca40
  val y : List[String] = x prepend "first string" //> y  : week03.session.List[String] = week03.session$Cons@70af26de
  val z : List[String] = y prepend "second string"//> z  : week03.session.List[String] = week03.session$Cons@7b20f29d
  y.head                                          //> res0: String = first string
  z.head                                          //> res1: String = second string
  z.tail.head                                     //> res2: String = first string
}