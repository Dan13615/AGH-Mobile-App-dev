package com.example.lab3

import kotlin.math.pow

//5 Class and objects
open class Animal {
    var name: String
    var age: Int
    var species: String

    constructor(name: String, age: Int, species: String) {
        this.name = name
        this.age = age
        this.species = species
    }

    open fun move() {
        println("$name is moving.")
    }

    override fun toString(): String {
        return "Hi I am a $species. I am $age years old and my name is $name."
    }
}

class Fish(name: String, age: Int) : Animal(name, age, "Fish") {
    override fun move() {
        println("$name is swimming.")
    }
}

class Dog(name: String, age: Int) : Animal(name, age, "Dog") {
    override fun move() {
        println("$name is running.")
    }
}


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
            "Enter operation: 'x y op' for binary (+,-,*,/,^), 'x !' for factorial, or 'exit' to stop:"
        )
        val input = readln().trim()
        if (input == "exit")
            break

        val parts = input.split("\\s+".toRegex())
        when (parts.size) {
            2 -> {
                val x = parts[0].toIntOrNull()
                val op = parts[1]
                if (x == null || op != "!") {
                    println("Invalid input. Use: 'x !'")
                    continue
                }
                calculator(x, 0, op)
            }
            3 -> {
                val x = parts[0].toIntOrNull()
                val y = parts[1].toIntOrNull()
                val op = parts[2]
                if (x == null || y == null) {
                    println("Invalid numbers. Use integers only.")
                    continue
                }
                calculator(x, y, op)
            }
            else -> println("Invalid input format.")
        }
    }
    //3.5

    print("Enter n for Fibonacci sequence: ")
    val n = readln().toIntOrNull()
    if (n == null || n <= 0) {
        println("n must be a positive integer")
    } else {
        println(fib(n).joinToString(" "))
    }

    //3.6

    print("Enter pr for pyramid: ")
    val pr = readln().toIntOrNull()
    if (pr == null || pr <= 0) {
        println("pr must be a positive integer")
    } else {
        piramide(pr)
    }

    //3.7

    print("Enter a string to reverse: ")
    val word = readln()
    rev_string(word)

    //4 Array

    var names: Array<String> = arrayOf("Lucas", "Dan", "Manou")

    println(names.joinToString(", "))

    for (i in names.indices) {
        println("$i: ${names[i]}")
    }
    //4.4
    find_longest(names)

    //4.5
    val randomNumbers = Array(100) { (1..100).random() }
    val randomNumbers2 = Array(100) { (1..100).random() }
    //insertion sort
    insertionSort(randomNumbers)
    //bubble sort
    bubbleSort(randomNumbers2)

    //5
    val animal1 = Animal("Puffy", 6, "spider")
    animal1.move()
    println(animal1)

    /* 
    * The method executed for the .move() method bellow are the method
    * overriden by the child classes Fish and Dog
    * this is the the principle of overriding with the keyword "override"
    * The parent class (Animal) method move() implementation is not longer 
    * used but replaced by the child classes' implementation
    */ 

    val animal2 = Fish("Nemo", 2)
    animal2.move()
    println(animal2)

    val animal3 = Dog("Buddy", 3)
    animal3.move()
    println(animal3)
}

fun calculator(x: Int, y: Int, op: String) {
    when (op) {
        //3.1
        "+" -> println(x + y)
        "-" -> println(x - y)
        "*" -> println(x * y)
        "/" -> {
            if (y == 0) {
                println("Division by zero is not allowed")
            } else {
                println(x / y)
            }
        }
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
    if (x < 0) {
        println("Factorial is undefined for negative numbers")
        return 0
    }
    var res = 1
    for (i in 1..x) {
        res *= i
    }
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

fun fib(n: Int): List<Int> {
    if (n <= 0) return emptyList()
    if (n == 1) return listOf(1)

    val result = mutableListOf(1, 1)
    while (result.size < n) {
        val next = result[result.size - 1] + result[result.size - 2]
        result.add(next)
    }
    return result
}

fun piramide(n: Int) {
    repeat(n) { print("*") }
    println()
    for (i in 1..n) {
        repeat(n - i) { print("*") }
        println()
    }
}

fun rev_string(word: String) {
    var result = ""
    for (i in word.length - 1 downTo 0) {
        result += word[i]
    }
    println(result)
}

fun find_longest(names: Array<String>) {
    var longest = ""
    for (name in names) {
        if (name.length > longest.length) {
            longest = name
        }
    }
    println("Longest name: $longest")
}

fun insertionSort(nbList: Array<Int>) {
    print("Original array: ${nbList.joinToString(", ")}")
    for (i in 1 until nbList.size) {
        val key = nbList[i]
        var j = i - 1
        while (j >= 0 && nbList[j] > key) {
            nbList[j + 1] = nbList[j]
            j--
        }
        nbList[j + 1] = key
    }
    println("Sorted array: ${nbList.joinToString(", ")}")
}

fun bubbleSort(nbList: Array<Int>) {
    print("Original array: ${nbList.joinToString(", ")}")
    for (i in 0 until nbList.size - 1) {
        for (j in 0 until nbList.size - i - 1) {
            if (nbList[j] > nbList[j + 1]) {
                val temp = nbList[j]
                nbList[j] = nbList[j + 1]
                nbList[j + 1] = temp
            }
        }
    }
    println("Sorted array: ${nbList.joinToString(", ")}")
}