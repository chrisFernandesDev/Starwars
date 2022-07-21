package com.projeto.starwars.viewmodel

import android.arch.lifecycle.*
import com.projeto.starwars.model.Filme

class FilmeViewModel(private val filme: Filme) : ViewModel() {

    private var filmesLiveData = MutableLiveData<ArrayList<Filme>>()
    val filmeLiveData: LiveData<ArrayList<Filme>>
        get() = filmesLiveData

    fun getFilmesLista(): MutableLiveData<ArrayList<Filme>> {

        return filmesLiveData
    }

}








//    var arrayListMutableLiveData = MutableLiveData<List<Filme>>()
//    var categoriaLista = ArrayList<Filme>()
//
////    val categoriaLista: LiveData<List<Categoria>>
////        get() = arrayListMutableLiveData
//
//    fun getCategoriListas(): MutableLiveData<List<Filme>> {
//
//
//        return arrayListMutableLiveData
//    }



//}