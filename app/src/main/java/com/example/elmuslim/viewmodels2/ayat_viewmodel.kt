package com.example.elmuslim.viewmodels2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elmuslim.Repo.ayat_repo
import com.example.elmuslim.data.models.AyahItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ayat_viewmodel @Inject constructor(
    private val ayatRepo: ayat_repo

) :ViewModel() {

//    private val _id = MutableLiveData<String>()
//    val id:LiveData<String> get() = _id



//    init {
//        getayat()
//    }

    private val _ayat = MutableStateFlow<List<AyahItem>>(emptyList())
    val ayat:StateFlow<List<AyahItem>> get() = _ayat

    private val _isloding = MutableStateFlow(false)
    val isloading :StateFlow<Boolean> get() = _isloding

    fun getayat(number:String){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _isloding.value=true
                val response = ayatRepo.getAyat(number)
                if (response.isSuccessful&&response.body()!=null){
                    withContext(Dispatchers.Main){
                        _ayat.value=response.body()!!
                        Log.d("data",response.body()!![0].toString())
                    }

                }

            }catch (exep:Exception){

                Log.d("error",exep.toString())

            }
            finally {
               _isloding.value=false
            }

        }

    }

}