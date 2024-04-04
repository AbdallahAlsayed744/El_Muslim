package com.example.elmuslim.data.models

data class Data(
    val available: Int,
    val hadiths: List<Hadith>,
    val id: String,
    val name: String,
    val requested: Int
)