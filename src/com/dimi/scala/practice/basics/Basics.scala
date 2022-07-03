package com.dimi.scala.practice.basics

import scala.annotation.tailrec

object Basics extends App {

  // 1. Hello World!
  def helloWorld(): Unit = {
    println("Hello World!")
  }

  def helloWorldShorter(): Unit = println("Hello World from Shorter!")


  // 2. Read two ints from command line and print their sum
  def readTwoIntsAndPrintTheirSum(): Unit = {
    print("Enter a first number:")
    val a = scala.io.StdIn.readInt()
    print("Enter a second number")
    val b = scala.io.StdIn.readInt()
    println(s"The sum is: ${a + b}")
  }

  //  3.Fibonacci
  //without tail recursion
  def fibonacci(n: Int): Int = {
    if (n == 1) {
      return 1
    }
    if (n == 2) {
      return 1
    }
    fibonacci(n - 1) + fibonacci(n - 2)
  }

  //with tail recursion
  def fibonacciTailRec(n: Int): Int = {
    @tailrec
    def helper(k: Int, prev: Int, current: Int): Int = {
      if (k >= n) {
        return current
      }
      helper(k + 1, current, prev + current)
    }

    assert(n >= 1)
    if (n == 1 || n == 2)
      return 1
    helper(3, 1, 2)
  }

}

