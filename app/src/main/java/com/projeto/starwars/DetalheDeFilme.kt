package com.projeto.starwars

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.projeto.starwars.viewmodel.DetalheDeFilmeViewModel


class DetalheDeFilme : AppCompatActivity() {

    lateinit var textoTitulo: TextView
    lateinit var imageCard: ImageView
    lateinit var textoData: TextView
    lateinit var nomeDiretor: TextView
    lateinit var nomeProdutor: TextView
    lateinit var episodio: TextView
    lateinit var textoSobre: TextView

    var viewModel: DetalheDeFilmeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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
        imageCard = findViewById(R.id.imagem_recebe_detalhes)
        textoData = findViewById(R.id.data_recebe)
        nomeDiretor = findViewById(R.id.diretor_recebe_detalhes)
        nomeProdutor = findViewById(R.id.producter_recebe_detalhes)
        episodio = findViewById(R.id.episode_recebe_detalhes)
        textoSobre = findViewById(R.id.text_sobre_recebe)
    }

    fun getObserve() {
        viewModel?.detalheDeFilme?.observe(this) { detalhesFilmes ->
            textoTitulo.text = detalhesFilmes.title
//            imageCard
            textoData.text = detalhesFilmes.release_date
            nomeDiretor.text = detalhesFilmes.director
            nomeProdutor.text = detalhesFilmes.producer
            episodio.text = detalhesFilmes.episode_id
            textoSobre.text = detalhesFilmes.opening_crawl
        }
    }
}