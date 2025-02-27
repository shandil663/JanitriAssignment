package com.example.janitriassignment.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.janitriassignment.data.local.model.VitalEntry
import kotlinx.coroutines.flow.Flow

@Dao
interface VitalDao {
    @Query("SELECT * FROM vital_entries ORDER BY timestamp DESC")
    fun getAllVitals(): Flow<List<VitalEntry>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertVital(vital: VitalEntry)
}
