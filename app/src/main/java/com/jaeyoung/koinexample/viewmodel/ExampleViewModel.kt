package com.jaeyoung.koinexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jaeyoung.koinexample.injectClass.PrintService
import org.koin.core.KoinComponent
import org.koin.core.inject

class ExampleViewModel : ViewModel() ,KoinComponent{
    private val liveData = MutableLiveData<Int>()
    val printService : PrintService by inject()
    val exampleData : LiveData<Int> get() = liveData

    fun reqData(data :Int){
        liveData.value = data
    }

    fun printHello(){
        printService.printHello()
    }

}