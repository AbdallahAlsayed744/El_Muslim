package com.example.elmuslim.ui.composes

import android.content.Context
import android.content.SharedPreferences
import android.media.MediaPlayer
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
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.elmuslim.AudioPlayer
import com.example.elmuslim.R
import com.example.elmuslim.data.models.Moshaf
import com.example.elmuslim.data.models.Quran
import com.example.elmuslim.data.models.QuranItem
import com.example.elmuslim.data.models.Reciter
import com.example.elmuslim.data.models.Suwar
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.viewmodels2.QuraanForListenViewmodel
import com.google.gson.Gson

@Composable
fun Suwarforreciters(navController: NavController, serv: Array<String>?, model:QuraanForListenViewmodel= hiltViewModel()) {
    val state by model.data.collectAsState()
//    val reciterstate by model.reciter.observeAsState()
    val isloading by model.loading.collectAsState()
//    model.getReciter(1)
    Column(modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 65.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.main_background),
                modifier = Modifier.fillMaxSize(),
                contentDescription = "",
                contentScale = ContentScale.Crop
            )
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
                    text = "السور",
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
            if (isloading) {

                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                    color = colorResource(id = R.color.hadis)
                )
            }

                quranlistenlazy2(state,serv)


            Log.d("myserverh", serv?.toList()?.toTypedArray().toString())


        }
    }
}


        @Composable
        fun Surahsbody2(data: Suwar,serv:Array<String>?) {
            val contxt = LocalContext.current
//            val sharedPreferences: SharedPreferences = contxt.getSharedPreferences("server",
//                Context.MODE_PRIVATE
//            )
            val x=Gson().toString()
            val serv2="https://server8.mp3quran.net/afs/003.mp3"
//           val y= Gson().fromJson(serv)
//            Gson().toJson(serv).toString()



//            val server = sharedPreferences.getString("server", "hhh").toString()
            Log.d("listien",x)
            val audioPlayer = remember { AudioPlayer(contxt,serv2) }
            val isPlaying = remember { mutableStateOf(false) }
            DisposableEffect(Unit) {
                onDispose {
                    audioPlayer.release()
                }
            }
//            var mediaPlayer: MediaPlayer? = null
//            val sharedPreferences: SharedPreferences = contxt.getSharedPreferences("server",
//                Context.MODE_PRIVATE
//            )
//            val server = sharedPreferences.getString("server", "hhh")



            Column(verticalArrangement = Arrangement.spacedBy(5.dp)) {


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                        .clickable {
//                    onclicktoquranpage(data.id,data.name_ar)
                        }
                ) {

                    Card(
                        modifier = Modifier
                            .width(40.dp)
                            .height(40.dp),
                        shape = RoundedCornerShape(5.dp),
                        colors = CardDefaults.cardColors(colorResource(id = R.color.card3))
                    ) {

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = data.id.toString() ?: "1",
                            modifier = Modifier.fillMaxSize(),
                            textAlign = TextAlign.Center,
                            color = colorResource(id = R.color.white),
                            fontSize = 14.sp
                        )

                    }
                    Spacer(modifier = Modifier.width(15.dp))
                    Column() {

                        Row(modifier = Modifier.fillMaxWidth(),horizontalArrangement = Arrangement.SpaceBetween) {


                            Text(
                                text = data.name ?: "ewefe",
                                modifier = Modifier
                                    .padding(end = 10.dp),
                                color = colorResource(id = R.color.color1),
                                fontSize = 18.sp,
                                fontFamily = amiri_bold,
                                textAlign = TextAlign.End
                            )

                            IconButton(onClick = {
                                if (isPlaying.value==false) {
                                    audioPlayer.start()
                                    isPlaying.value=true
                                }
                                else{
                                    audioPlayer.stop()
                                    isPlaying.value=false
                                }
//                                    Log.d("listen",it)

                        }) {


                                        Icon(
                                        painter = if (isPlaying.value==false) {
                                            painterResource(id = R.drawable.baseline_play_arrow_24)
                                        } else {
                                            painterResource(id = R.drawable.baseline_pause_24)
                                        },
                                        tint = colorResource(id = R.color.color1),
                                        contentDescription = "",
                                        modifier = Modifier
                                        )





                            }
                        }




                    }


                }

                Image(
                    painter = painterResource(id = R.drawable.line),
                    modifier = Modifier.fillMaxWidth(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )


            }
        }
@Composable
fun quranlistenlazy2(datalist:List<Suwar>,serv:Array<String>?) {

    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(top = 120.dp)
    ){
        items(datalist){
            Surahsbody2(data = it, serv = serv)


        }


    }

}




