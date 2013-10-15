package week02

object session {
  def sumLong(f: Int => Int)(a: Int, b: Int): Int = {
    def loop(a: Int, acc: Int): Int = {
      if (a > b) acc
      else loop(a + 1, f(a) + acc)
    }
    loop(a, 0)
  }                                               //> sumLong: (f: Int => Int)(a: Int, b: Int)Int

  sumLong(x => x)(3, 5)                           //> res0: Int = 12

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f)(a + 1, b)
  }                                               //> sum: (f: Int => Int)(a: Int, b: Int)Int
  sum(x => x)(3, 5)                               //> res1: Int = 12

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  }                                               //> product: (f: Int => Int)(a: Int, b: Int)Int
  product(x => x * x)(3, 4)                       //> res2: Int = 144

  def fact(n: Int) = product(x => x)(1, n)        //> fact: (n: Int)Int
  fact(5)                                         //> res3: Int = 120

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }                                               //> mapReduce: (f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b:
                                                  //|  Int)Int

  def product2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)
                                                  //> product2: (f: Int => Int)(a: Int, b: Int)Int
  product2(x => x * x)(3, 4)                      //> res4: Int = 144

  def sum2(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x + y, 0)(a, b)
                                                  //> sum2: (f: Int => Int)(a: Int, b: Int)Int
  sum2(x => x)(3, 5)                              //> res5: Int = 12

  val x = new Rational(1, 3)                      //> x  : week02.Rational = 1/3
  x.numerator                                     //> res6: Int = 1
  x.denominator                                   //> res7: Int = 3
  -x                                              //> res8: week02.Rational = 1/-3

  val y = new Rational(5, 7)                      //> y  : week02.Rational = 5/7
  //x.add(y)
  //x.sub(y)
  x+y                                             //> res9: week02.Rational = 22/21

  val z = new Rational(3, 2)                      //> z  : week02.Rational = 3/2

  x- y - z                                        //> res10: week02.Rational = -79/42
  y + y                                           //> res11: week02.Rational = 10/7

  val v = new Rational(10, 5)                     //> v  : week02.Rational = 2/1
}

class Rational(x: Int, y: Int) {
  require(y != 0, "invalid denominator")
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numerator = x
  val denominator = y

  def + (other: Rational) =
    new Rational(numerator * other.denominator + other.numerator * denominator, denominator * other.denominator)
    
  def - (other: Rational) =
    this + -other
    
  def unary_- =
    new Rational(-numerator, denominator)

  override def toString = {
    val g = gcd(numerator, denominator)
    (numerator / g) + "/" + (denominator / g)
  }
}