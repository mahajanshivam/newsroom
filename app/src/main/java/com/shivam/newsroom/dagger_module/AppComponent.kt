package com.shivam.newsroom.dagger_module

import android.app.Application
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(AndroidInjectionModule::class, BuildersModule::class, AppModule::class,NetModule::class)
)

interface AppComponent {
    fun inject(app: Application)
}