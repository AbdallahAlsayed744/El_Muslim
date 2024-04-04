package com.example.elmuslim.viewmodels2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elmuslim.Repo.ahades_repo
import com.example.elmuslim.data.models.Data
import com.example.elmuslim.data.models.Hadith
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ahadis_viemodel @Inject constructor(
    private val repo:ahades_repo
):ViewModel() {

    private val _ahadis = MutableStateFlow<List<Hadith>>(emptyList())
    val ahadis:StateFlow<List<Hadith>> get()  = _ahadis

    private val _isloading= MutableStateFlow(false)
    val isloading:StateFlow<Boolean> get()  = _isloading

    init {
        getmyahadis()
    }


    fun getmyahadis(){
        viewModelScope.launch (Dispatchers.IO){
            try {
                _isloading.value=true
                val response=repo.getallahadis("1-20")
                if (response.isSuccessful&&response.body()!=null){
                    _ahadis.value= response.body()!!.data.hadiths

                    Log.d("ahadis",response.body().toString())

                }

            }catch (e:Exception){

                Log.d("Exception",e.message.toString())
            }finally {
                _isloading.value=false
            }



        }


    }

}