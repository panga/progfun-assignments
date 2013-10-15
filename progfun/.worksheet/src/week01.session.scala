package week01

object session {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(77); 
  def abs(x: Double) = if (x < 0) -x else x;System.out.println("""abs: (x: Double)Double""");$skip(317); 

  def sqrt(x: Double) = {

    def sqrtIter(guess: Double): Double =
      if (isGoodEnough(guess)) guess else
        sqrtIter(improve(guess))

    def isGoodEnough(guess: Double) =
      abs(guess * guess - x) / x < 0.001

    def improve(guess: Double) =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  };System.out.println("""sqrt: (x: Double)Double""");$skip(12); val res$0 = 

  sqrt(1);System.out.println("""res0: Double = """ + $show(res$0));$skip(10); val res$1 = 
  sqrt(2);System.out.println("""res1: Double = """ + $show(res$1));$skip(10); val res$2 = 
  sqrt(4);System.out.println("""res2: Double = """ + $show(res$2));$skip(14); val res$3 = 
  sqrt(0.001);System.out.println("""res3: Double = """ + $show(res$3));$skip(16); val res$4 = 
  sqrt(0.1e-20);System.out.println("""res4: Double = """ + $show(res$4));$skip(13); val res$5 = 
  sqrt(1e20);System.out.println("""res5: Double = """ + $show(res$5));$skip(13); val res$6 = 
  sqrt(1e50);System.out.println("""res6: Double = """ + $show(res$6));$skip(163); 

  def factorial(n: Int): Int = {
    def loop(acc: Int, n: Int): Int =
      if (n == 0)
        acc
      else
        loop(acc * n, n - 1)

    loop(1, n)
  };System.out.println("""factorial: (n: Int)Int""");$skip(17); val res$7 = 

  factorial(4);System.out.println("""res7: Int = """ + $show(res$7))}
}
