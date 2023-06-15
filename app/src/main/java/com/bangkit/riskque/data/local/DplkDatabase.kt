package com.bangkit.riskque.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bangkit.riskque.model.Dplk
import com.bangkit.riskque.data.database.DplkDao
import com.bangkit.riskque.data.database.RemoteKeys
import com.bangkit.riskque.data.database.RemoteKeysDao

@Database(
    entities = [Dplk::class, RemoteKeys::class],
    version = 2,
    exportSchema = false
)

abstract class DplkDatabase : RoomDatabase() {

    abstract fun dplkDao(): DplkDao
    abstract fun remoteKeysDao(): RemoteKeysDao

    companion object {
        @Volatile
        private var INSTANCE: DplkDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): DplkDatabase {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    DplkDatabase::class.java, "dplk_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}