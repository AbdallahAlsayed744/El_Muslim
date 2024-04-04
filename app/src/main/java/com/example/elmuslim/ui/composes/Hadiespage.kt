package com.example.elmuslim.ui.composes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.elmuslim.data.models.Hadith
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.ui.theme.amiri_reqular
import com.example.elmuslim.utilis.constants
import com.example.elmuslim.viewmodels2.ahadis_viemodel

@SuppressLint("SuspiciousIndentation")
@Composable
fun Hadispage(navController: NavController,model:ahadis_viemodel = hiltViewModel()) {
    val state by model.ahadis.collectAsState()
    val isloading by model.isloading.collectAsState()
    


        Box(modifier = Modifier.fillMaxSize()){
            Image(painter = painterResource(id = R.drawable.main_background), modifier = Modifier.fillMaxSize(),contentDescription = "", contentScale = ContentScale.Crop)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp), horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                        contentDescription = ""
                    )

                }
                Text(
                    text = "الاحاديث النبوية",
                    modifier = Modifier.align(Alignment.CenterVertically),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    fontFamily = amiri_bold,
                    color = colorResource(id = R.color.black)
                )

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_more_vert_24),
                        contentDescription = ""
                    )

                }

            }


            if(isloading){
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center).padding(top = 140.dp), color = colorResource(id = R.color.hadis)

                )
            }


            Hadislazy(datalist = state,{
                navController.navigate("${constants.spasfichadispage}/${it}")
            })
        }

        

    }





@Composable
fun Hadisbody(data:Hadith,onclick:(String)->Unit) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(100.dp)
        .padding(top = 10.dp).clickable {
                            onclick(data.arab)
        },
        colors = CardDefaults.cardColors(colorResource(id = R.color.hadis))
        ) {

        Text(text = "  الحديث رقم ${data.number}"?:"wfqffef" , modifier = Modifier.fillMaxWidth().padding(top=10.dp),textAlign = TextAlign.Center, fontSize = 24.sp, fontFamily = amiri_bold)

    }
}

@Composable
fun Hadislazy(datalist:List<Hadith>,onclick: (String) -> Unit){
    LazyColumn(contentPadding = PaddingValues(10.dp), modifier = Modifier.padding(top = 150.dp)) {
        items(datalist){
            Hadisbody(data = it,onclick)

        }
    }
}

//
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun previewhadispage(){
//    Hadisbody(data =(Hadith("","1",2,)))
//
//}
