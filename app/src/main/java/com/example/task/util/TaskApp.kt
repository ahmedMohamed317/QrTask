package com.example.task.util

import android.app.Application
import android.content.Context
import com.example.task.BuildConfig
import com.example.task.di.repositoryModule
import com.example.task.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import timber.log.Timber

class TaskApp : Application() {


    val listModule: List<Module> = listOf(
//        apiModule,
        viewModelModule,
        repositoryModule,

    )

    companion object {
        private var mContext: TaskApp? = null

        fun getContext(): Context? {
            return mContext
        }

    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin {
            androidLogger()
            androidContext(this@TaskApp)

            modules(
                listModule
            )
        }

    }



}