package com.projeto.starwars.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.projeto.starwars.api.ApiCliente
import com.projeto.starwars.model.Filme
import com.projeto.starwars.model.ListaDeFilmes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetalheDeFilmeViewModel() : ViewModel() {

    private val _detalheDeFilme = MutableLiveData<Filme>()
    var detalheDeFilme: LiveData<Filme> = _detalheDeFilme

    fun fetchFilmsId(id: String): Call<Filme> {
        return ApiCliente.apiService.fetchFilmsId(id)
    }

    fun apiFilmeID(idFilme: String) {
        fetchFilmsId(idFilme).enqueue(object : Callback<Filme> {
            override fun onResponse(
                call: Call<Filme>,
                response: Response<Filme>,
            ) {
                if (response.isSuccessful) {
                    _detalheDeFilme.value = response.body()
                }
            }

            override fun onFailure(call: Call<Filme>, t: Throwable) {
                Log.e("VM Detalhe failed", "" + t.message)
            }
        })
    }
}