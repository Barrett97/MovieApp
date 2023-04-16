package com.tranbarret.movielist

import android.app.Application
import com.tranbarret.movielist.di.ApplicationComponent
import com.tranbarret.movielist.di.DaggerApplicationComponent
import com.tranbarret.movielist.util.Lawg

class MovieApplication : Application() {

    init {
        Lawg.i("----------------------------- APP STARTED -----------------------------")
        instance = this
    }

    companion object {

        private var instance : MovieApplication? = null
        fun getInstance() = instance ?: throw IllegalStateException("Called getInstance before application was created")
    }

    val appComponent: ApplicationComponent = DaggerApplicationComponent.builder()
            .application(this)
            .context(this)
            .build()

//    companion object {
//        internal val component: ApplicationComponent = DaggerApplicationComponent.builder().build()
//    }

//    companion object {
//        private var instance: MovieApplication? = null
//        fun getInstance() = instance
//            ?: throw IllegalStateException("Called getInstance before application was created")
//    }
//
//    init {
//        instance = this
//    }
//
//    private var myComponent: ApplicationComponent? = null
//
//    fun getAppComponent(): ApplicationComponent {
//        val component = myComponent
//        if (component == null) {
//            createApplicationComponent().apply {
//                myComponent = this
//                return this
//            }
//        } else {
//            return component
//        }
//    }
//
//    private fun createApplicationComponent(): ApplicationComponent {
//        return DaggerApplicationComponent
//            .builder()
//            .build()
//    }
 }