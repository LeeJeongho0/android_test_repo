package com.example.androidfirst

fun main() {
    val objval:Super = Child(name1 = "종구")
    println(objval.superData)
    objval.superFun()
}

open class Super constructor(var name:String){
    open var superData = 10
    open fun superFun(){
        println("I am super class function ${superData}")
    }
}

class Child constructor(var name1:String):Super(name1){
    override var superData: Int = 20
    override fun superFun() {
    println("I am child class function ${superData}")
    }
}