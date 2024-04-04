package com.example.elmuslim.ui.composes

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elmuslim.R
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.ui.theme.poppeni_bold

@Composable
fun Homepage(onclick: () -> Unit,onclick2: () -> Unit,onclick3: () -> Unit,onclick4: () -> Unit){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        Box(modifier = Modifier.height(120.dp)){

            topbar(text = "المُسَلِّم", onclickmenue = {  }) {

        }


            }


        Hpager()
        Spacer(modifier = Modifier.height(40.dp))

        Row (horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            qurancard(onclick)
            Headphonecard(onclick4)
        }

        Row (horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
            PrayerTimings_card(onclick2)
            Sebhacard(onclick3)
        }








    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Hpager(){
    val vorizenral = rememberPagerState { 3 }
    HorizontalPager(state = vorizenral, verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 25.dp)) {
        when(it){
            0-> Headcard()
            1-> Headcard2()
            2-> Headcard3()
        }

    }
}



@Composable
fun Headcard(){
    Box(modifier = Modifier
        .width(350.dp)
        .height(200.dp)
        .clip(shape = RoundedCornerShape(5.dp))
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    colorResource(id = R.color.hadis),
                    colorResource(id = R.color.card1)
                )
            )
        )){
//        Image(painter = painterResource(id = R.drawable.cardcolor), modifier = Modifier.fillMaxSize(),contentDescription = "", contentScale = ContentScale.Crop)
        Image(painter = painterResource(id = R.drawable.image), modifier = Modifier
            .fillMaxSize()
            .height(100.dp), alignment = Alignment.Center, contentDescription = "")
        Box(modifier = Modifier.padding(bottom = 8.dp).fillMaxSize(), contentAlignment = Alignment.BottomCenter){
    circularandicator(background1 = colorResource(id = R.color.card1), background2 =  colorResource(id = R.color.grey), background3  = colorResource(id = R.color.grey))

     }


    }



}
@Composable
fun Headcard2(){
    Box(modifier = Modifier
        .width(350.dp)
        .height(200.dp)
        .clip(shape = RoundedCornerShape(5.dp))
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    colorResource(id = R.color.hadis),
                    colorResource(id = R.color.card1)
                )
            )
        )){
//        Image(painter = painterResource(id = R.drawable.cardcolor), modifier = Modifier.fillMaxSize(),contentDescription = "", contentScale = ContentScale.Crop)
        Image(painter = painterResource(id = R.drawable.sebha), modifier = Modifier
            .fillMaxSize()
            .height(100.dp), alignment = Alignment.BottomEnd, contentDescription = "")
        Box(modifier = Modifier.padding(bottom = 8.dp).fillMaxSize(), contentAlignment = Alignment.BottomCenter){
            circularandicator(background1 = colorResource(id = R.color.grey), background2 =  colorResource(id = R.color.white), background3  = colorResource(id = R.color.grey))

        }

    }



}
@Composable
fun Headcard3(){
    Box(modifier = Modifier
        .width(350.dp)
        .height(200.dp)
        .clip(shape = RoundedCornerShape(5.dp))
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    colorResource(id = R.color.hadis),
                    colorResource(id = R.color.card1)
                )
            )
        )){
//        Image(painter = painterResource(id = R.drawable.cardcolor), modifier = Modifier.fillMaxSize(),contentDescription = "", contentScale = ContentScale.Crop)
        Image(painter = painterResource(id = R.drawable.body_of_sebha), modifier = Modifier
            .fillMaxSize()
            .height(100.dp), alignment = Alignment.BottomEnd, contentDescription = "")
        Box(modifier = Modifier.padding(bottom = 8.dp).fillMaxSize(), contentAlignment = Alignment.BottomCenter){
            circularandicator(background1 = colorResource(id = R.color.grey), background2 =  colorResource(id = R.color.grey), background3  = colorResource(id = R.color.white))

        }

    }



}



@Composable
fun qurancard(onclick:()->Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.card1)),
        modifier = Modifier
            .width(170.dp)
            .height(160.dp)
            .clickable {
                onclick()
            }
    ) {
        Column() {
            Text(text = "القرآن الكريم ", color = colorResource(id = R.color.muslim), fontFamily = poppeni_bold, fontSize = 20.sp ,modifier = Modifier.padding(14.dp))

            Image(painter = painterResource(id = R.drawable.quran), contentDescription ="", modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 50.dp, top = 20.dp))

        }

    }
}
@Composable
fun Headphonecard(onclick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.hadis)),
        modifier = Modifier
            .width(180.dp)
            .height(190.dp)
            .clickable {
                onclick()
            }
    ) {
        Column() {
            Text(text = "الاستماع", color = colorResource(id = R.color.muslim), fontFamily = amiri_bold, fontSize = 22.sp ,modifier = Modifier.padding(start=14.dp))

            Image(painter = painterResource(id = R.drawable.headphone), contentDescription ="", modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 50.dp, top = 10.dp))


        }

    }
}
@Composable
fun PrayerTimings_card(onclick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.hadis)),
        modifier = Modifier
            .width(180.dp)
            .height(190.dp)
            .clickable {
                onclick()

            }
    ) {
        Column() {
            Text(text =" الاحاديث النبوية ", color = colorResource(id = R.color.muslim), fontFamily = amiri_bold, fontSize = 20.sp ,modifier = Modifier.padding(start=14.dp))

            Image(painter = painterResource(id = R.drawable.hadis), contentDescription ="", modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(start = 50.dp, bottom = 10.dp))


        }

    }
}
@Composable
fun Sebhacard(onclick: () -> Unit) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(colorResource(id = R.color.card1)),
        modifier = Modifier
            .width(170.dp)
            .height(220.dp)
            .padding(vertical = 30.dp)
            .clickable {
                onclick()
            }

    ) {
        Column() {
            Text(text = "التسبيح", color = colorResource(id = R.color.muslim), fontFamily = amiri_bold, fontSize = 22.sp ,modifier = Modifier.padding(start = 14.dp))

            Image(painter = painterResource(id = R.drawable.sebha), contentDescription ="", modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(start = 50.dp, bottom = 10.dp))


        }

    }
}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun previewhomepage(){
//    Homepage()
//}
//
//
