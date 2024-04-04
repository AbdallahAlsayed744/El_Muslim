package com.example.elmuslim.Repo

import android.util.Log
import com.example.elmuslim.data.models.Quran
import com.example.elmuslim.datasources.remote.Api
import retrofit2.Response
import javax.inject.Inject

class quranpage_repo @Inject constructor(
    private val myapi:Api
) {
    suspend fun getdatafromquran():Response<Quran>{
        val response = myapi.getallquran()
        if (response.isSuccessful&&response.body()!=null){
            Log.d("quranresponse","Succssfull")
            Log.d("quranresponse",response.body().toString())
        }
        else{
            Log.d("quranresponse","faild")
            Log.d("quranresponse",response.body().toString())
        }

        return response


    }

}