package com.projeto.starwars


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projeto.starwars.adapter.FilmeAdapter
import com.projeto.starwars.model.Filme
import com.projeto.starwars.model.ListaDeFilmes
import com.projeto.starwars.viewmodel.FilmeViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    var viewModel: FilmeViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pegaView()

        viewModel = ViewModelProvider(this).get(FilmeViewModel::class.java)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        getObserve()
        viewModel?.apiFilmeMake()

    }

    fun getObserve() {
        viewModel?.listFilmes?.observe(this) { listaFilmes ->
            val adapter = FilmeAdapter(this, listaFilmes)
            recyclerView.adapter = adapter
        }
    }

    fun pegaView() {
        recyclerView = findViewById(R.id.recyclerView)
    }

}