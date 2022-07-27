package com.projeto.starwars.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.projeto.starwars.R
import com.projeto.starwars.model.Filme
import com.squareup.picasso.Picasso

typealias OnItemClickListener =  (filme : Filme) -> Unit

class FilmeAdapter(
    private val context: Context,
    private val filme: List<Filme>,
    private val onItemClickListener : OnItemClickListener
): RecyclerView.Adapter<FilmeAdapter.FilmeViewHolder>() {

//    private lateinit var mListener : OnItemClickListener

    inner class FilmeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData( filme: Filme){
            val imageCard = itemView.findViewById<ImageView>(R.id.imageCard_recebe)
            val textoTituloRecebe = itemView.findViewById<TextView>(R.id.texto_titulo_recebe)
            val textoEpisodioFixo = itemView.findViewById<TextView>(R.id.texto_episodio_fixo)
            val textoEpisodioRecebe = itemView.findViewById<TextView>(R.id.texto_episodio_recebe)
            val nomeDiretorRecebe = itemView.findViewById<TextView>(R.id.nome_diretor_recebe)
            val nomeAnoRecebe = itemView.findViewById<TextView>(R.id.nome_ano_recebe)

            Picasso.get().load(filme.image).into(imageCard)
            textoTituloRecebe.text = filme.title
            textoEpisodioFixo.text
            textoEpisodioRecebe.text = filme.episode_id
            nomeDiretorRecebe.text = filme.director
            nomeAnoRecebe.text = filme.release_date

            itemView.setOnClickListener {
                onItemClickListener(filme)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmeViewHolder {
        val itemLista = LayoutInflater.from(context).inflate(R.layout.activity_listagem_de_filme, parent, false)
        val holder = FilmeViewHolder(itemLista)
        return holder
    }

    override fun onBindViewHolder(holder: FilmeViewHolder, position: Int) {
        holder.bindData(filme[position])
    }

    override fun getItemCount(): Int {
        return filme.size
    }

//    fun setOnItemClickListener(listener: OnItemClickListener){
//        mListener = listener
//    }

//    interface OnItemClickListener{
//        fun onItemClick(position : Int)
//    }
}