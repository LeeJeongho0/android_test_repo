package com.example.androidfirst

fun main() {
    var data = 86

    when(data){
        in 90..100 -> println("data is A")
        in 80..90 -> println("data is B")
        else -> println("data is not valid data")
    }
}