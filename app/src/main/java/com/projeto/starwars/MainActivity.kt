package com.projeto.starwars


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projeto.starwars.adapter.FilmeAdapter
import com.projeto.starwars.model.Filme
import com.projeto.starwars.viewmodel.FilmeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var viewModel: FilmeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        getView()

        viewModel = ViewModelProvider(this).get(FilmeViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        getObserve()
        viewModel?.apiFilmeMake()
    }

    fun getObserve() {
        viewModel?.listFilmes?.observe(this) { listaFilmes ->
            val adapter = FilmeAdapter(this, listaFilmes) { filme ->
                val intent = Intent(this, DetalheDeFilme::class.java)
                intent.putExtra("idFilme", extrairIdFilme(filme))
                startActivity(intent)
            }
            recyclerView.adapter = adapter
        }
    }

    fun getView() {
        recyclerView = findViewById(R.id.recyclerView)
    }

    fun extrairIdFilme(filme: Filme) = filme.url.last { it != '/' }.toString()
}