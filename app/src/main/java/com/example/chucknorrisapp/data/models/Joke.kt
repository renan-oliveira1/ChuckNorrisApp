package com.example.chucknorrisapp.data.models

import com.google.gson.annotations.SerializedName

data class Joke(
    val id: String,
    val value: String,

    @SerializedName("icon_url")
    val iconURL: String,
    val url: String)
