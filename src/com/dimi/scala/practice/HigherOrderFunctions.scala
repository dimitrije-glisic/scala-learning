package com.dimi.scala.practice

import scala.annotation.tailrec

object HigherOrderFunctions extends App {

  // 1. Function sum is linearly recursive. Write the same function which uses terminal (trail) recursion
  //  def sum(f: Int => Double)(a: Int, b: Int): Double = {
  //    if ( a>b ) 0 else f(a) + sum(f)(a+1, b)
  //  }

  def sumTrailRec(f: Int => Double)(a: Int, b: Int): Double = {
    @tailrec
    def inner(acc: Double, a: Int): Double = {
      if (a > b) acc else inner(acc + f(a), a + 1)
    }

    inner(0, a)
  }

  // 2. Similarly, write a function for calculating product
  def prodTailRec(f: Int => Double)(a: Int, b: Int): Double = {
    @tailrec
    def inner(acc: Double, a: Int): Double = {
      if (a > b) acc else inner(acc * f(a), a + 1)
    }

    inner(1, a)
  }

  //3. Generalize the approach
  def generalize(g: (Double, Double) => Double, accInitVal: Double)(f: Int => Double)(a: Int, b: Int): Double = {
    @tailrec
    def inner(acc: Double, a: Int): Double = {
      if (a > b) acc else inner(g(acc, f(a)), a + 1)
    }

    inner(accInitVal, a)
  }

  //try it out
  val start = 3
  val end = 6

  val sum = generalize((x, y) => x + y, 0)(x => x)(start, end)
  println(sum)

  val prod = generalize((x, y) => x * y, 1)(x => x)(start, end)
  println(prod)
}
