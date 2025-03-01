package com.example.gestordeatividades.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gestordeatividades.model.Atividade
import seu_pacote.data.AtividadeDao

@Database(entities = [Atividade::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun atividadeDao(): AtividadeDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "atividades_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}