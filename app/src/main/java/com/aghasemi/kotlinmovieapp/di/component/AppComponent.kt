package com.aghasemi.kotlinmovieapp.di.component

import com.aghasemi.kotlinmovieapp.App
import com.aghasemi.kotlinmovieapp.di.module.ActivityBuildersModule
import com.aghasemi.kotlinmovieapp.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton
import dagger.android.support.AndroidSupportInjectionModule


@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    override fun inject(app: App)
    //fun inject(glideModule: GlideModule)

    /**
     * Builder of [AppComponent]
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: App): Builder

        fun build(): AppComponent
    }
}