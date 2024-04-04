package com.example.elmuslim.viewmodels2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elmuslim.Repo.quranpage_repo
import com.example.elmuslim.data.models.QuranItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class quranpage_viewmodel @Inject constructor(
    private val repo:quranpage_repo
) :ViewModel() {
    private val _surah = MutableStateFlow<List<QuranItem>>(emptyList())

    val surah :StateFlow<List<QuranItem>> get() = _surah

    private val _loading = MutableStateFlow(false)
    val loading :StateFlow<Boolean> get() = _loading

    init {
        getSurahnames()
    }

    fun getSurahnames(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loading.value=true
                val response = repo.getdatafromquran()
                if (response.isSuccessful&&response.body()!=null){
                    withContext(Dispatchers.Main){
                        _surah.value=response.body()!!
                    }


                }

            }catch (e:Exception){

                Log.d("networkerror",e.message.toString())

            }
            finally {
                _loading.value=false
            }
        }

    }

}