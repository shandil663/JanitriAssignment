package com.example.janitriassignment.data.local.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.janitriassignment.data.local.model.VitalEntry

@Database(entities = [VitalEntry::class], version = 1, exportSchema = false)
abstract class VitalDatabase : RoomDatabase() {
    abstract fun vitalDao(): VitalDao

    companion object {
        @Volatile
        private var INSTANCE: VitalDatabase? = null

        fun getDatabase(context: Context): VitalDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VitalDatabase::class.java,
                    "vital_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
