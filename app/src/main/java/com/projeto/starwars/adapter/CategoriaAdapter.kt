package com.projeto.starwars.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.projeto.starwars.R
//import com.projeto.starwars.model.Categoria
//
//class CategoriaAdapter(private val context: Context, private val categoria: MutableList<Categoria>): RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
//        val itemLista = LayoutInflater.from(context).inflate(R.layout.activity_listagem_de_filme, parent, false)
//        val holder = CategoriaViewHolder(itemLista)
//        return holder
//    }
//
//    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
//
//    }
//
////    override fun getItemCount(): Int {
////    }
//
//    inner class CategoriaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    }
//}