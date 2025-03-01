package com.example.gestordeatividades.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "atividades")
data class Atividade(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nome: String,
    val responsavel: String,
    val data: String,
    val descricao: String
)