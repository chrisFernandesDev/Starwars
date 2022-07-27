package com.projeto.starwars.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projeto.starwars.api.ApiCliente
import com.projeto.starwars.model.Filme
import com.projeto.starwars.model.ListaDeFilmes
import retrofit2.Response

class FilmeViewModel() : ViewModel() {

    private val filmes = MutableLiveData<List<Filme>>()
    var listFilmes: LiveData<List<Filme>> = filmes

    val apiFilme = ApiCliente.apiService.fetchFilms()

    fun apiFilmeMake(){
        apiFilme.enqueue(object: retrofit2.Callback<ListaDeFilmes>{
            override fun onResponse(
                call: retrofit2.Call<ListaDeFilmes>,
                response: Response<ListaDeFilmes>
            ) {
                if (response.isSuccessful) {
                    val filmeLista = response.body()?.films
                    filmes.value = filmeLista?.sortedWith(compareBy { it.episode_id })
                }
            }
            override fun onFailure(call: retrofit2.Call<ListaDeFilmes>, t: Throwable) {
                Log.e("VM failed", "" + t.message)
            }
        })
    }
}