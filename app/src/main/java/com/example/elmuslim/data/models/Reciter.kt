package com.example.elmuslim.data.models

data class Reciter(
    val date: String,
    val id: Int,
    val letter: String,
    val moshaf: List<Moshaf>,
    val name: String
)