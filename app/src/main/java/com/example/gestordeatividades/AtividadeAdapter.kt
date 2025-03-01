package com.example.gestordeatividades

class AtividadeAdapter : RecyclerView.Adapter<AtividadeAdapter.ViewHolder>() {
    private var lista = emptyList<Atividade>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nome: TextView = view.findViewById(R.id.txtNome)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_atividade, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nome.text = lista[position].nome
    }

    override fun getItemCount() = lista.size

    fun atualizarLista(novaLista: List<Atividade>) {
        lista = novaLista
        notifyDataSetChanged()
    }
}
