package com.example.elmuslim.viewmodels2

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elmuslim.Repo.quranlistionRepo
import com.example.elmuslim.data.models.Reciter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class QuranListiningViewmodel @Inject constructor(
    private val repo : quranlistionRepo
):ViewModel() {
    private val _data = MutableStateFlow<List<Reciter>>(emptyList())
    val data: StateFlow<List<Reciter>> get() = _data

    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading

    init {
        getQuranlistin()
    }

    fun getQuranlistin(){
        viewModelScope.launch (Dispatchers.IO){
            try {
                _loading.value=true
                val response =repo.getQuranlisting()
                if (response.isSuccessful&&response.body()!=null){
                    _data.value=response.body()!!.reciters

                }

            }
            catch (e:Exception){
                Log.d("error",e.message.toString())

            }finally {
                _loading.value=false
            }
        }
    }



}