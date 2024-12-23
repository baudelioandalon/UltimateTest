package com.boreal.ultimatetest.games.domain.interfaces

import androidx.room.Database
import androidx.room.RoomDatabase
import com.boreal.ultimatetest.games.domain.model.GamesModelItemDto

@Database(entities = [GamesModelItemDto::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): GamesDao
}