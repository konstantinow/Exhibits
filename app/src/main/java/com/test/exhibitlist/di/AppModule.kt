package com.test.exhibitlist.di

import com.test.exhibitlist.main.IMainModel
import com.test.exhibitlist.main.MainModel
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface AppModule {
    @Binds
    @Singleton
    fun provideMainModel(mainModel: MainModel): IMainModel
}
