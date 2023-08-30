package com.aghasemi.kotlinmovieapp.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.aghasemi.kotlinmovieapp.model.Movie

@Dao
interface MovieDao : BaseDao<Movie> {
    @Query("SELECT * FROM movie")
    fun getAll(): LiveData<List<Movie>>

    @Query("SELECT * FROM movie where type=:type")
    fun getAllWithType(type: String): LiveData<List<Movie>>

}