package com.example.janitriassignment.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.janitriassignment.data.local.db.VitalDatabase
import com.example.janitriassignment.data.local.model.VitalEntry
import com.example.janitriassignment.data.repository.VitalRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class VitalViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: VitalRepository
    val allVitals: StateFlow<List<VitalEntry>>

    init {
        val dao = VitalDatabase.getDatabase(application).vitalDao()
        repository = VitalRepository(dao)
        allVitals = repository.allVitals.stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            emptyList()
        )
    }

    fun insertVital(vital: VitalEntry) = viewModelScope.launch {
        repository.insert(vital)
    }
}
