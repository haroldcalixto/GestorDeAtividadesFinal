package com.example.gestordeatividades.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.gestordeatividades.data.AppDatabase
import kotlinx.coroutines.launch
import com.example.gestordeatividades.model.Atividade

class AtividadeViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).atividadeDao()
    val listaAtividades: LiveData<List<Atividade>> = dao.listarTodas()

    fun adicionarAtividade(atividade: Atividade) {
        viewModelScope.launch {
            dao.inserir(atividade)
        }
    }
}
