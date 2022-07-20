package com.projeto.starwars.model

import com.google.gson.annotations.SerializedName
import com.projeto.starwars.api.Repositorio
import java.util.*
import kotlin.collections.ArrayList

data class Filme(
    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("episode_id")
    val episode_id: Int,

    @SerializedName("opening_crawl")
    val opening_crawl: String,

    @SerializedName("director")
    val director: String,

    @SerializedName("producer")
    val producer: String,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("url")
    val url: String
)
