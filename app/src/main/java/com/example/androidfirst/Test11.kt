package com.example.androidfirst

fun main() {
    var sum:Int
    sum = 0
    for(i in 10 downTo 1){
        sum += i
    }
    println("sum = ${sum}")
}