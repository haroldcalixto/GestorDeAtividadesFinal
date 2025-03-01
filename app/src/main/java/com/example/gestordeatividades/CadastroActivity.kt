class CadastroActivity : AppCompatActivity() {
    private lateinit var viewModel: AtividadeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        viewModel = ViewModelProvider(this).get(AtividadeViewModel::class.java)

        findViewById<Button>(R.id.btnSalvar).setOnClickListener {
            val nome = findViewById<EditText>(R.id.edtNome).text.toString()
            val responsavel = findViewById<EditText>(R.id.edtResponsavel).text.toString()
            val data = findViewById<EditText>(R.id.edtData).text.toString()
            val descricao = findViewById<EditText>(R.id.edtDescricao).text.toString()

            if (nome.isNotEmpty() && responsavel.isNotEmpty() && data.isNotEmpty()) {
                viewModel.adicionarAtividade(Atividade(0, nome, responsavel, data, descricao))
                finish()
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
