package com.example.finalproject

import android.app.Application
import com.example.finalproject.data.AppContainer
import com.example.finalproject.data.AppDataContainer

class ItemsApplication : Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}
