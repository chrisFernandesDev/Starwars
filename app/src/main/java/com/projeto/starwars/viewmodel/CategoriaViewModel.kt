package com.projeto.starwars.viewmodel

import android.arch.lifecycle.*
import com.projeto.starwars.model.Filme
import java.util.ArrayList

class CategoriaViewModel(filme: Filme) : ViewModel() {

    var arrayListMutableLiveData = MutableLiveData<List<Filme>>()
    var categoriaLista = ArrayList<Filme>()

//    val categoriaLista: LiveData<List<Categoria>>
//        get() = arrayListMutableLiveData

    fun getCategoriListas(): MutableLiveData<List<Filme>> {


        return arrayListMutableLiveData
    }



}