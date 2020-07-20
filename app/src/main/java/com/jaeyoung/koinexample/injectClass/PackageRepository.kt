package com.jaeyoung.koinexample.injectClass

import android.content.Context

class PackageRepository(context: Context) {
    val packageName = context.packageName
}