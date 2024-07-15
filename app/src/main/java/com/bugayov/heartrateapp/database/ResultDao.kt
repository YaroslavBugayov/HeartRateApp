package com.bugayov.heartrateapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ResultDao {
    @Insert
    fun insert(result: ResultEntity)

    @Query("SELECT * FROM results")
    fun getAll() : Flow<List<ResultEntity>>
}