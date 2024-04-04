package com.example.elmuslim.ui.composes

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.elmuslim.R
import com.example.elmuslim.data.models.QuranItem
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.ui.theme.poppeni_bold
import com.example.elmuslim.utilis.constants
import com.example.elmuslim.viewmodels2.quranpage_viewmodel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun quranpage( navController: NavController,model:quranpage_viewmodel= hiltViewModel()){
    val state by model.surah.collectAsState()
    val isloading by model.loading.collectAsState()
    Column(modifier = Modifier
        .fillMaxSize()
        ) {
        Box(modifier = Modifier.height(100.dp)){
            Quranpage_topbar(text = "المُسَلِّم", onclickmenue = { navController.navigateUp() }) {

            }
        }

        if (isloading){
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally), color = colorResource(id = R.color.card3)

            )
        }

            quranpagelazy(datalist = state,{id,name->
                navController.navigate("${constants.ayapag}/${id}/${name}")
            })


    }

    
}

@Composable
fun Surahsbody(data:QuranItem,onclicktoquranpage:(id:String,name:String)->Unit) {

    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    onclicktoquranpage(data.id,data.name_ar)
                }
        ) {

            Card(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    ,
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.card3))
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = data.number?:"1",
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center,
                    color = colorResource(id = R.color.white),
                    fontSize = 14.sp
                )

            }
            Spacer(modifier = Modifier.width(15.dp))
            Column() {
                Text(
                    text = data.name_en?:"wdwdqwd",
                    color = colorResource(id = R.color.black),
                    fontSize = 18.sp
                )

                Text(text = data.type?:"34343", color = colorResource(id = R.color.grey), fontSize = 16.sp)


            }

            Text(
                text = data.name_ar?:"ewefe",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 10.dp),
                color = colorResource(id = R.color.color1),
                fontSize = 18.sp,
                fontFamily = amiri_bold,
                textAlign = TextAlign.End
            )

        }

        Image(painter = painterResource(id = R.drawable.line), modifier = Modifier.fillMaxWidth(), contentDescription = "", contentScale = ContentScale.Crop)




    }
}

@Composable
fun quranpagelazy(datalist:List<QuranItem>,onclicktoquranpage:(id:String,name:String)->Unit) {

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        ){
        items(datalist){
            Log.d("data",it.toString())
            Surahsbody(data = it,onclicktoquranpage)

        }


    }

}
