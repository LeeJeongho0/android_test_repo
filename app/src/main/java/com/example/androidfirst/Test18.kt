package com.example.androidfirst

val addValue = { ->
    10 + 20
}

fun sum(addValue:()->Int):Unit{
    println("합계는 = ${addValue()}")
}


fun main() {
    sum(addValue)
}
