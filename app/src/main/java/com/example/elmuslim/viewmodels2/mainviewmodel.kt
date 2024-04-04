package com.example.elmuslim.viewmodels2

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elmuslim.utilis.constants
import com.example.newsapp.save_entry.myappsaveorread
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.time.delay
import java.time.Duration
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class mainviewmodel@Inject constructor(
    private val myappsaveorread: myappsaveorread
): ViewModel() {
    var splashcondition by mutableStateOf(true)
        private set

    var startdistination by mutableStateOf(constants.welcomepage)
        private set
    init {
        myappsaveorread.readentry().onEach {shouldstartfromhomescreen->
            if(shouldstartfromhomescreen){

                startdistination = constants.startpage
            }
            else {
                startdistination = constants.welcomepage
            }

            delay(Duration.ofSeconds(3))


            splashcondition=false



        }.launchIn(viewModelScope)
    }




}