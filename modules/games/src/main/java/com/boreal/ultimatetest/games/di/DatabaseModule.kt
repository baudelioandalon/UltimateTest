package com.boreal.ultimatetest.games.di

import android.app.Application
import androidx.room.Room
import com.boreal.ultimatetest.games.domain.interfaces.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun database(application: Application) = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "test_db",
    ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

    @Provides
    @Singleton
    fun provideGamesDao(appDatabase: AppDatabase) =
        appDatabase.gamesDao()


}
