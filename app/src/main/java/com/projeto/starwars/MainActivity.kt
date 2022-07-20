package com.projeto.starwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.projeto.starwars.api.ApiCliente
import com.projeto.starwars.model.ListaDeFilmes
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pegaView()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val cliente = ApiCliente.apiService.fetchFilms()

        cliente.enqueue(object : retrofit2.Callback<ListaDeFilmes> {

            override fun onResponse(
                call: Call<ListaDeFilmes>,
                response: Response<ListaDeFilmes>
            ) {
                if (response.isSuccessful){
                    Log.d("results", "teste" + response.body())
                }
            }

            override fun onFailure(call: Call<ListaDeFilmes>, t: Throwable) {
                Log.e("MainActivity failed", "" + t.message)
            }
        })
    }

    fun pegaView(){
        recyclerView = findViewById(R.id.recyclerView)
    }

}