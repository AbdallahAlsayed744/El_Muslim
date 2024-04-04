package com.example.elmuslim.ui.composes

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LiveData
import androidx.navigation.NavController
import com.example.elmuslim.R
import com.example.elmuslim.data.models.AyahItem
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.viewmodels2.ayat_viewmodel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@SuppressLint("ResourceType")
@Composable
fun Ayat_page(navController: NavController,id:String?, name:String?,model:ayat_viewmodel= hiltViewModel()){

    val isloading by model.isloading.collectAsState()
    val state by model.ayat.collectAsState()
    model.getayat(id.toString())

    Column(modifier = Modifier
        .fillMaxSize()
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = R.drawable.main_background),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription ="" )

                }
                Text(text = name.toString(), modifier = Modifier.align(Alignment.CenterVertically), textAlign = TextAlign.Center, fontSize = 20.sp, fontFamily = amiri_bold, color = colorResource(id = R.color.black))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_more_vert_24), contentDescription ="" )

                }

            }
        if (isloading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center), color = colorResource(id = R.color.card3)
            )

        }
//

            Ayah(data = state)

        }
    }



}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun Ayah(data:List<AyahItem>) {



    LazyColumn(modifier = Modifier.padding(top = 180.dp)) {
        items(data) {
            Log.d("lenghth", it.number_in_surah.length.toString())

            var number by remember {
                mutableStateOf(it.number_in_surah.length)
            }


            FlowRow(modifier = Modifier.fillMaxWidth().background(if (it.number_in_surah.toInt() % 2 == 0) colorResource(id = R.color.card1) else colorResource(id = R.color.card2))) {



                Text(
                    text = it.text ?: "dqwdq",
                    fontSize = 20.sp,
                    fontFamily = amiri_bold,
                    color = colorResource(id = R.color.black),
                    modifier = Modifier.padding(top = 20.dp, start = 7.dp, end = 12.dp),
                    textAlign = TextAlign.Right
                )

                Box(
                    modifier = Modifier
                        .padding(top = 25.dp, start = 5.dp)
                        .width(40.dp)
                        .height(40.dp),
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ayah),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = it.number_in_surah, modifier = Modifier
                            .fillMaxSize()
                            .align(Alignment.Center)
                            .padding(top = 10.dp), textAlign = TextAlign.Center
                    )
                }
            }

        }


}}