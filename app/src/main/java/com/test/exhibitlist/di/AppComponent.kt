package com.test.exhibitlist.di

import android.content.Context
import com.test.exhibitlist.main.MainActivity
import com.test.exhibitlist.main.MainPresenter
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun inject(mainView: MainActivity)
    fun inject(mainPresenter: MainPresenter)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }
}
