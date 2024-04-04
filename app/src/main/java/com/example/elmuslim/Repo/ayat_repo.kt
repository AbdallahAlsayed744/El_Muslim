package com.example.elmuslim.Repo

import android.util.Log
import com.example.elmuslim.data.models.Ayah
import com.example.elmuslim.datasources.remote.Api
import retrofit2.Response
import javax.inject.Inject

class ayat_repo @Inject constructor(
    private val my_api:Api
) {

    suspend fun getAyat(number:String):Response<Ayah>{
        val response=my_api.getallquranAyah(number)
        if (response.isSuccessful&&response.body()!=null){
            Log.d("ayat_repo","Successfull")
            Log.d("ayat_repo",response.body().toString())
        }
        else{
            Log.d("ayat_repo","faild")
            Log.d("ayat_repo",response.body().toString())
        }
        return response

    }


}