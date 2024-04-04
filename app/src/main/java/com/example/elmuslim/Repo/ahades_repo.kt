package com.example.elmuslim.Repo

import android.util.Log
import com.example.elmuslim.data.models.Ahadis
import com.example.elmuslim.datasources.remote.Api_Ahadis
import retrofit2.Response
import javax.inject.Inject

class ahades_repo @Inject constructor(
    private val api: Api_Ahadis
) {

    suspend fun getallahadis(range:String):Response<Ahadis>{
        val response = api.getallahadis(range)
        if (response.isSuccessful&&response.body()!=null){
            Log.d("ahadis_repo","Successfull")
            Log.d("ahadis_repo",response.body().toString())


        }
        else{
            Log.d("ahadis_repo","Faild")
            Log.d("ahadis_repo",response.body().toString())

        }
        return response


    }

}