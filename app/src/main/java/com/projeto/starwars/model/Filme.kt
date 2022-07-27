package com.projeto.starwars.model

import com.google.gson.annotations.SerializedName

data class Filme(
    @SerializedName("image")
    val image: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("episode_id")
    val episode_id: String,

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