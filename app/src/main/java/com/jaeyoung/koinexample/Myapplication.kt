package com.jaeyoung.koinexample

import android.app.Application
import com.jaeyoung.koinexample.injectClass.InjectCountData
import com.jaeyoung.koinexample.injectClass.PackageRepository
import com.jaeyoung.koinexample.injectClass.PrintService
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

class Myapplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@Myapplication)
            modules(myModule)
        }
    }
    val myModule = module {
        single {
            PackageRepository(androidContext())
        }

        single {
            PrintService(get())
        }

        factory {
            InjectCountData()
        }
    }
}