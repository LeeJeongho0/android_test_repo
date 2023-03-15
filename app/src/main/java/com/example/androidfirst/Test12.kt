package com.example.androidfirst

fun main() {
    var data: Array<Int> = arrayOf<Int>(10,20,30)
    var sum: Int = 0
    for(i in data.indices){
        sum += data.get(i)
        print("${data[i]} \t")
        if(i !== data.size-1) {
            print("\t|\t")
        }
    }
    print("\n sum = ${sum}")
}