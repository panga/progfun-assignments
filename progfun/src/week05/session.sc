package week05

object session {

  def fib1(n: Int): BigInt = {
    def fibs(n: Int): (BigInt, BigInt) = if (n == 1) (1, 0) else {
      val (a, b) = fibs(n / 2)
      val p = (2 * b + a) * a
      val q = a * a + b * b
      if (n % 2 == 0) (p, q) else (p + q, p)
    }
    fibs(n)._1
  }                                               //> fib1: (n: Int)BigInt

  def fib2: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fib2.zip(fib2.tail).map { n => n._1 + n._2 }
                                                  //> fib2: => Stream[BigInt]

  def fib3: Stream[BigInt] = {
    def tail(h: BigInt, n: BigInt): Stream[BigInt] = h #:: tail(n, h + n)
    tail(0, 1)
  }                                               //> fib3: => Stream[BigInt]
  //fib1(350000)
  //fib2(24)
  //fib3(150000)

  for {
    i <- 1 until 7
    j <- 1 until i
    if 1 == 1
  } yield (i, j)                                  //> res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((2,1), (3,1
                                                  //| ), (3,2), (4,1), (4,2), (4,3), (5,1), (5,2), (5,3), (5,4), (6,1), (6,2), (6,
                                                  //| 3), (6,4), (6,5))

  val countries = Map("BR" -> "Brasilia")         //> countries  : scala.collection.immutable.Map[String,String] = Map(BR -> Brasi
                                                  //| lia)

  countries.get("BR").isDefined                   //> res1: Boolean = true
  countries.get("US").isEmpty                     //> res2: Boolean = true
}