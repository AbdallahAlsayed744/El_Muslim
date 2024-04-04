package com.example.elmuslim.datasources.remote

import com.example.elmuslim.data.models.Ahadis
import com.example.elmuslim.data.models.Ayah
import com.example.elmuslim.data.models.Quran
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("surahs")
    suspend fun getallquran():Response<Quran>

    @GET("ayah")
    suspend fun getallquranAyah(
        @Query("number") number:String
    ):Response<Ayah>



}