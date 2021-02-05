package com.daerawind.nextdoor

import android.app.Application
import com.daerawind.nextdoor.di.myModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            logger(AndroidLogger(Level.ERROR))
            androidContext(this@MyApp)
            modules(myModules)
        }
    }
}