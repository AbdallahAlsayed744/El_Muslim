package com.example.elmuslim.Repo

import android.util.Log
import com.example.elmuslim.data.models.Qraa
import com.example.elmuslim.data.models.Quraanlisnters
import com.example.elmuslim.datasources.remote.Api_lesinting
import retrofit2.Response
import javax.inject.Inject

class QuraanForListenRepo @Inject constructor(
    private val api:Api_lesinting
) {
    suspend fun getsurah():Response<Quraanlisnters>{
        val response = api.getSuwar()
        if (response.isSuccessful&&response.body()!=null){
            Log.d("response","Success")
            Log.d("response",response.body().toString())
        }
        else{
            Log.d("response","Fail")
            Log.d("response",response.body().toString())
        }
        return response

    }

    suspend fun getreciter(reciter:Int):Response<Qraa>{
        val response = api.getreciter(reciter)
        if (response.isSuccessful&&response.body()!=null){
            Log.d("response","Success")
            Log.d("response",response.body().toString())
        }
        else{
            Log.d("response","Fail")
            Log.d("response",response.body().toString())
        }
        return response
    }


}