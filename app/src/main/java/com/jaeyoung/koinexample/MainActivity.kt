package com.jaeyoung.koinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jaeyoung.koinexample.injectClass.InjectCountData
import com.jaeyoung.koinexample.viewmodel.ExampleViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    lateinit var exampleVieModel : ExampleViewModel

    val inject_0 by inject<InjectCountData>()
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val androidViewModelFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        exampleVieModel = ViewModelProvider(this,androidViewModelFactory).get(ExampleViewModel::class.java)

        exampleVieModel.exampleData.observe(this, Observer {
            Log.d("test",it.toString())
        })

        test_btn.setOnClickListener {
            exampleVieModel.reqData(i++)
        }

        exampleVieModel.printHello()
        inject_0.printlnCount()
    }
}