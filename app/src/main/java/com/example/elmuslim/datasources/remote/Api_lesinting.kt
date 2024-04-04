package com.example.elmuslim.datasources.remote

import com.example.elmuslim.data.models.Qraa
import com.example.elmuslim.data.models.Quraanlisnters
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api_lesinting {

    @GET("reciters")
    suspend fun getLesinting(
        @Query("language") language:String="ar"
    ):Response<Qraa>

    @GET("suwar")
    suspend fun getSuwar(
        @Query("language") language:String="ar"
    ):Response<Quraanlisnters>

    @GET("reciters")
    suspend fun getreciter(
        @Query("reciter") reciter:Int,
        @Query("language") language:String="ar",

    ):Response<Qraa>
}