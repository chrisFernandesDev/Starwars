package com.projeto.starwars.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.projeto.starwars.model.Categoria
import java.util.ArrayList

class CategoriaViewModel(categoria : Categoria) : ViewModel() {
    
    var arrayListMutableLiveData = MutableLiveData<List<String>>()

    var categoriaArrayLista = ArrayList<String>()

    fun getCategoriArrayLista(): MutableLiveData<List<String>> {

        val categoria1 = Categoria(id = "teste", titulo = "teste")
        val categoria2 = Categoria(id = "teste2", titulo = "teste2")

        val categoriaViewModelLista1 : CategoriaViewModel = CategoriaViewModel(categoria1)
        val categoriaViewModelLista2 : CategoriaViewModel = CategoriaViewModel(categoria2)

        categoriaArrayLista!!.add(categoriaViewModelLista1.toString())
        categoriaArrayLista!!.add(categoriaViewModelLista2.toString())

        arrayListMutableLiveData.value = categoriaArrayLista

        return arrayListMutableLiveData
    }

}