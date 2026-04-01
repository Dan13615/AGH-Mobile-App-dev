package com.example.lab3

import kotlin.math.pow

fun main() {
    // 2.1-2.3
    val a = 1
    val b = 2
    var c = a + b
    println(c)
    // 2.4
    println("The result of $a + $b = $c")
    println("The result of " + a + " + " + b + " = " + c)
    // 2.5
    println("The value of incremented c is " + ++c)
    /* 2.6
    * 'val' cannot be reassigned
    *
    * val c = a + b
    * println("The value of incremented c is " + ++c)
    *
    * val is the way to declare a constant in kotlin, so it cannot be changed
    * */
    // 2.7
    print("Enter a number : ")
    val input1 = readln()
    println("The type of the word is : ${input1!!::class.simpleName}")
    println("The number is : $input1")

    print("Enter a word : ")
    val input2 = readln()
    println("The type of the word is : ${input2!!::class.simpleName}")
    println("The word is : $input2")

    // readLine()
    /*
    * Reads a line of input from the standard input stream.
    * This function is obsolete and will be deprecated soon.
    * Consider using readln or readlnOrNull depending on how the end of the input
    * stream should be handled.
    *
    * Note from the official docs
    * */
    print("Enter a number : ")
    val input3 = readLine()
    println("The type of the word is : ${input3!!::class.simpleName}")
    println("The number is : $input3")

    print("Enter a word : ")
    val input4 = readLine()
    println("The type of the word is : ${input4!!::class.simpleName}")
    println("The word is : $input4")

    /*
    *
    *
    * */


    //3 Calculator
    while (true) {
        println(
            "Enter two numbers and the operator you want to use separated by a space" +
                    " ('x' 'y' '[+,-,*,/]') :"
        )
        val (nb1, nb2, op) = readln().split(' ')
        if (nb1 == "exit")
            break
        val x = nb1.toInt()
        val y = nb2.toInt()

        calculator(x, y, op)
    }
}

fun calculator(x: Int, y: Int, op: String) {
    when (op) {
        //3.1
        "+" -> println(x + y)
        "-" -> println(x - y)
        "*" -> println(x * y)
        "/" -> println(x / y)
        //3.2
        "!" -> println(factorial(x))
        "^" -> {
            println(x.toDouble().pow(y.toDouble()))
            println(pow1(x, y))
            println(pow2(x, y))
            println(pow3(x, y))
        }
        //3.3
        else -> println("Operation not handled")
    }
}

fun factorial(x: Int): Int {
    var res = 1
    var i = 0
    for (i in 0..x)
        res *= (i + 1)
    return res
}

fun pow1(x: Int, y: Int): Int {
    if (y == 0) return 1
    var res = x
    for (i in 2..y) {
        res *= x
    }
    return res
}

fun pow2(x: Int, y: Int): Int {
    if (y == 0) return 1
    var res = x
    var i = 0
    while (i < y - 1) {
        res *= x
        i++
    }
    return res
}

fun pow3(x: Int, y: Int): Int {
    if (y == 0) return 1
    var res = x
    repeat(y - 1) {
        res *= x
    }
    return res
}

// fun fib(n: Int) {
//     var
// }