package com.projeto.starwars

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.projeto.starwars.viewmodel.DetalheDeFilmeViewModel


class DetalheDeFilme : AppCompatActivity() {

    lateinit var textoTitulo: TextView
    var viewModel: DetalheDeFilmeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        getView()

        val idFilme = intent.getStringExtra("idFilme")

        viewModel = ViewModelProvider(this).get(DetalheDeFilmeViewModel::class.java)
        getObserve()
        if (idFilme != null) {
            viewModel?.apiFilmeID(idFilme)
        } else {
            finish()
        }
    }

    fun getView() {
        textoTitulo = findViewById(R.id.titulo_recebe_detalhes)
    }

    fun getObserve() {
        viewModel?.detalheDeFilme?.observe(this) { detalhesFilmes ->
            textoTitulo.text = detalhesFilmes.title
        }
    }

}