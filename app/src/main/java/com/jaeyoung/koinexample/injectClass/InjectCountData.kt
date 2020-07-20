package com.jaeyoung.koinexample.injectClass

class InjectCountData {
    companion object{
        var injectCount = 0
    }
    init {
        injectCount++
    }
    fun printlnCount(){
        println("InjectCount=$injectCount")
    }
}