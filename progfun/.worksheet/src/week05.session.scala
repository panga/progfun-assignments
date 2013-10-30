package week05

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(292); 

  def fib1(n: Int): BigInt = {
    def fibs(n: Int): (BigInt, BigInt) = if (n == 1) (1, 0) else {
      val (a, b) = fibs(n / 2)
      val p = (2 * b + a) * a
      val q = a * a + b * b
      if (n % 2 == 0) (p, q) else (p + q, p)
    }
    fibs(n)._1
  };System.out.println("""fib1: (n: Int)BigInt""");$skip(104); 

  def fib2: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fib2.zip(fib2.tail).map { n => n._1 + n._2 };System.out.println("""fib2: => Stream[BigInt]""");$skip(126); 

  def fib3: Stream[BigInt] = {
    def tail(h: BigInt, n: BigInt): Stream[BigInt] = h #:: tail(n, h + n)
    tail(0, 1)
  };System.out.println("""fib3: => Stream[BigInt]""");$skip(126); val res$0 = 
  //fib1(350000)
  //fib2(24)
  //fib3(150000)

  for {
    i <- 1 until 7
    j <- 1 until i
    if 1 == 1
  } yield (i, j);System.out.println("""res0: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$0));$skip(44); 

  val countries = Map("BR" -> "Brasilia");System.out.println("""countries  : scala.collection.immutable.Map[String,String] = """ + $show(countries ));$skip(34); val res$1 = 

  countries.get("BR").isDefined;System.out.println("""res1: Boolean = """ + $show(res$1));$skip(30); val res$2 = 
  countries.get("US").isEmpty;System.out.println("""res2: Boolean = """ + $show(res$2))}
}
