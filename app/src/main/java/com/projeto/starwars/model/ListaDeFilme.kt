package com.projeto.starwars.model

import com.google.gson.annotations.SerializedName

data class ListaDeFilmes(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    var films: ArrayList<Filme>
)