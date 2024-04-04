package com.example.elmuslim.viewmodels2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.save_entry.myappsaveorread
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class onbording_viwmodel @Inject constructor(
    private val myappsaveorread: myappsaveorread
) : ViewModel() {

    fun myevent(event: on_obordingevent) {
        when (event) {
            is on_obordingevent.saveappentry -> {
                saveappentry()
            }
        }
    }

    private fun saveappentry() {
        viewModelScope.launch {
            myappsaveorread.saveentry()
        }

    }

}