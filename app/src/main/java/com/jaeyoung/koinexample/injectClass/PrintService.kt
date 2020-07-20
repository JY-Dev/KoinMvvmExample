package com.jaeyoung.koinexample.injectClass

class PrintService(val packageRepository: PackageRepository) {
    fun printHello(){
        println("Hello:"+packageRepository.packageName)
    }
}