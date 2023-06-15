package com.bangkit.riskque.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bangkit.riskque.model.Dplk

@Dao
interface DplkDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDplk(dplk: List<Dplk>)

    @Query("SELECT * FROM dplk")
    fun getAllDplk(): PagingSource<Int, Dplk>

    @Query("DELETE FROM dplk")
    suspend fun deleteAll()
}