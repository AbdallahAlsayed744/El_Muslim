package com.example.elmuslim.ui.composes

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.elmuslim.R
import com.example.elmuslim.data.models.Reciter
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.utilis.constants
import com.example.elmuslim.viewmodels2.QuranListiningViewmodel

@Composable
fun QuranListining(navController: NavController,model: QuranListiningViewmodel= hiltViewModel()) {
    val state by model.data.collectAsState()
    val isloading by model.loading.collectAsState()
    Column(modifier = Modifier) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(top = 65.dp)){
            Image(painter = painterResource(id = R.drawable.main_background), modifier = Modifier.fillMaxSize(),contentDescription ="", contentScale = ContentScale.Crop)
            Row (modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                IconButton(onClick = { navController.navigateUp() }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_arrow_back_24), contentDescription ="" )

                }
                Text(text = "القراء", modifier = Modifier.align(Alignment.CenterVertically), textAlign = TextAlign.Center, fontSize = 24.sp, fontFamily = amiri_bold, color = colorResource(id = R.color.black))

                IconButton(onClick = { /*TODO*/ }) {
                    Icon(painter = painterResource(id = R.drawable.baseline_more_vert_24), contentDescription ="" )

                }

            }
            if (isloading){

                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center), color = colorResource(id = R.color.hadis))
            }
            
            quranlistenlazy(datalist = state)
            {
                server->
                server?.let {
                    navController.navigate("${constants.Suwarforreciters}/${it}")
                }

//            Log.d("test",it)
            }
        }

    }
    

}

@Composable
fun Quranlistenbody(data: Reciter,onclicktosurapage:(Array<String>?)->Unit) {
    val context= LocalContext.current
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("server",MODE_PRIVATE)
    val sharedit: SharedPreferences.Editor = sharedPreferences.edit()


    Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    sharedit.putString(data.moshaf[0].server,"server")
                    sharedit.apply()
                    val mydata=data.moshaf[0].server
                    Log.d("testme",data.moshaf[0].server)
                    onclicktosurapage(arrayOf(mydata))



                }
        ) {

            Card(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                ,
                shape = RoundedCornerShape(5.dp),
                colors = CardDefaults.cardColors(colorResource(id = R.color.hadis))
            ) {

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = data.id.toString()?:"1",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.white),
                fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column() {
                Text(
                    text = data.name?:"wdwdqwd",
                    modifier = Modifier.fillMaxWidth(),
                    color = colorResource(id = R.color.black),
                    fontSize = 18.sp,
                    fontFamily = amiri_bold,
                    textAlign = TextAlign.Center
                )



            }


        }

        Image(painter = painterResource(id = R.drawable.line), modifier = Modifier.fillMaxWidth(), contentDescription = "", contentScale = ContentScale.Crop)




    }
}

@Composable
fun quranlistenlazy(datalist:List<Reciter>,onclicktosurapage:(Array<String>?)->Unit) {

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(top = 120.dp)
    ){
        items(datalist){
            Quranlistenbody(data = it,onclicktosurapage)
           

        }


    }

}
