package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {

  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   *
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   *
   *   val s1 = singletonSet(1)
   *
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   *
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   *
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val u12 = union(s1, s2)
    val u23 = union(s2, s3)
    val u123 = union(u12, u23)
    def greaterThan2(x: Int) = x > 2
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   *
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {

    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3".
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
      assert(contains(u123, 1), "Union 123 contains 1")
      assert(contains(u123, 2), "Union 123 contains 2")
      assert(contains(u123, 3), "Union 123 contains 3")
      assert(!contains(u123, 4), "Union 123 does not contains 4")
    }
  }
  test("diff") {
    new TestSets {

      assert(contains(diff(u12, singletonSet(1)), 2), "union with singleton")
      assert(contains(diff(s1, s2), 1), "diff complex")
    }
  }
  test("filter") {
    new TestSets {

      assert(contains(filter(u123, greaterThan2), 3), "filter 2")
      assert(!contains(filter(u123, greaterThan2), 1), "filter 1")
    }
  }
  test("forall") {
    new TestSets {
      assert(!forall(u123, greaterThan2))
      assert(forall(u123, (x: Int) => x > 0))
    }
  }

  test("exists") {
    new TestSets {
      def isNegative(x: Int) = x < 0
      val u = union(u123, singletonSet(-1))
      val um12 = union(u, singletonSet(-2))
      assert(exists(u, isNegative), "negative number exist in set -1 1 2 3")
      assert(exists(um12, isNegative), "negative number exist in set -2 -1 1 2 3")
      assert(!exists(u123, isNegative), "negative number does not exist in set 1 2 3")
    }
  }

  test("map") {
    new TestSets {
      def mult2(x: Int) = x * 2
      def sqr(x: Int) = x * x
      def u123mult2 = map(u123, mult2)
      def u123sqr = map(u123, sqr)
      assert(contains(u123mult2, 4), "a set 1 2 3 mult2 contains 4")
      assert(!contains(u123mult2, 1), "a set 1 2 3 mult2 does not contain 1")
      assert(contains(u123sqr, 4), "a set 1 2 3 squared contains 4")
      assert(!contains(u123sqr, 2), "a set 1 2 3 squared does not contain 2")
    }

  }
}
