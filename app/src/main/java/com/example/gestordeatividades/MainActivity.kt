package com.example.gestordeatividades

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gestordeatividades.ui.theme.GestorDeAtividadesTheme

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: AtividadeViewModel
    private lateinit var adapter: AtividadeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        adapter = AtividadeAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this).get(AtividadeViewModel::class.java)
        viewModel.listaAtividades.observe(this) { atividades ->
            adapter.atualizarLista(atividades)
        }

        findViewById<Button>(R.id.btnNovaAtividade).setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}
