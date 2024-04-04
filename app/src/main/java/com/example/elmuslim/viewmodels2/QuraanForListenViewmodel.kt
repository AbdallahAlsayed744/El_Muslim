package com.example.elmuslim.viewmodels2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elmuslim.Repo.QuraanForListenRepo
import com.example.elmuslim.data.models.Moshaf
import com.example.elmuslim.data.models.Reciter
import com.example.elmuslim.data.models.Suwar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuraanForListenViewmodel @Inject constructor(
    private val repo: QuraanForListenRepo
) :ViewModel() {

    private val _data =MutableStateFlow<List<Suwar>>(emptyList())
    val data :StateFlow<List<Suwar>> get() = _data
    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> get() = _loading
    private val _reciter = MutableLiveData<Reciter>()
    val reciter : LiveData<Reciter> get() = _reciter
    init {
        getsuwar()
//        getReciter(1)
    }

    fun getsuwar(){
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _loading.value=true
                val response=repo.getsurah()
                if (response.isSuccessful&&response.body()!=null){
                    _data.value=response.body()!!.suwar
                }

            }catch (e:Exception){
                Log.d("error",e.message.toString())
            }finally {
                _loading.value=false
            }
        }

    }

    fun getReciter(reciter: Int){
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val response=repo.getreciter(reciter)
                if (response.isSuccessful&&response.body()!=null){
                    _reciter.value=response.body()!!.reciters[0]
                }
    }catch (e:Exception){

            }



            }    }

}