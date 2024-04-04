package com.example.elmuslim.Repo

import android.util.Log
import com.example.elmuslim.data.models.Qraa
import com.example.elmuslim.datasources.remote.Api_lesinting
import retrofit2.Response
import javax.inject.Inject

class quranlistionRepo @Inject constructor(
    private val api:Api_lesinting
) {

    suspend fun getQuranlisting():Response<Qraa>{
        val response=api.getLesinting()
        if (response.isSuccessful&&response.body()!=null){
            Log.d("responseQuranlising","success")
            Log.d("responseQuranlising",response.body().toString())

        }
        else{
            Log.d("responseQuranlising","fail")
            Log.d("responseQuranlising",response.body().toString())
        }
        return response


    }


}