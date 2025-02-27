package com.example.janitriassignment.data.repository

import com.example.janitriassignment.data.local.db.VitalDao
import com.example.janitriassignment.data.local.model.VitalEntry
import kotlinx.coroutines.flow.Flow

class VitalRepository(private val vitalDao: VitalDao) {
    val allVitals: Flow<List<VitalEntry>> = vitalDao.getAllVitals()

    suspend fun insert(vital: VitalEntry) {
        vitalDao.insertVital(vital)
    }
}
