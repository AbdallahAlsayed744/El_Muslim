package com.example.elmuslim.datasources.remote

import com.example.elmuslim.data.models.Ahadis
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api_Ahadis {

    @GET("muslim")
    suspend fun getallahadis(
        @Query("range") number:String,



    ): Response<Ahadis>

    @GET("muslim/{number}")
    suspend fun getspaceficahadis(
        @Path("number") number:Int,

        ): Response<Ahadis>
}