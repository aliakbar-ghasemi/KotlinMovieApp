package com.aghasemi.kotlinmovieapp.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(t: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(t: List<T>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun suspendInsert(t: T)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun suspendInsertAll(t: List<T>)
}