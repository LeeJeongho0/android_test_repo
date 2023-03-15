package com.example.androidfirst

fun main() {
    val returnValue = ramdaFunc(calBoolean)
    println(returnValue())
}


//fun calBoolean(no:Int):Boolean{
//    println("no = ${no}")
//    return no > 10
//}

val calBoolean = { no: Int ->
    println("no = ${no}")
    no > 10
}

fun ramdaFunc(arg: (Int) -> Boolean): () -> String {
    println(arg(5))

    return { val value = "길동"; "return value ${value}" }
}

//fun returnString():String{
//    val value = "길동"
//    return "return value ${value}"
//}

//val returnValue = {
//    val value = "길동"
//    "return value ${value}"
//}

