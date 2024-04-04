package com.example.elmuslim.ui.composes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.elmuslim.R
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.ui.theme.poppeni_bold

@Composable
fun Tasbeahpage(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        var rotation by remember { mutableStateOf(0f) }
        var count by remember { mutableStateOf(0) }

        Box (modifier = Modifier.fillMaxSize()){
            Image(
                painter = painterResource(id = R.drawable.main_background),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
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
                    text = "السبحة",
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

            Image(painter = painterResource(id = R.drawable.head_of_sebha), contentDescription ="",
                modifier = Modifier
                    .padding(top = 146.dp, end = 20.dp)
                    .fillMaxWidth()
                    .height(80.dp), alignment = Alignment.Center)

            Image(painter = painterResource(id = R.drawable.body_of_sebha), contentDescription ="",
                modifier = Modifier
                    .padding(top = 205.dp)
                    .fillMaxWidth()
                    .height(250.dp)
                    .rotate(rotation), alignment = Alignment.Center)
            Card(modifier = Modifier
                .padding(top = 474.dp)
                .height(60.dp)
                .width(130.dp)
                .align(Alignment.TopCenter),colors = CardDefaults.cardColors(colorResource(id = R.color.hadis))) {
                Text(text = count.toString(), fontSize = 20.sp, modifier = Modifier.fillMaxSize().padding(top = 15.dp), textAlign = TextAlign.Center, fontFamily = poppeni_bold)

            }

            Button(
                onClick = {
                    rotation += 5f
                    count += 1
                },
                modifier = Modifier
                    .padding(top = 560.dp)
                    .width(290.dp)
                    .height(70.dp)

                    .align(Alignment.TopCenter),
                shape = RoundedCornerShape(7.dp),
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.hadis))
            ) {
                Text(
                    "سبحان الله ",

                    fontSize = 25.sp,
                    fontFamily = amiri_bold,
                    color = colorResource(id = R.color.black),
                )
            }

        }

    }

}
//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun Tasbeahpagepreview(){
//    Tasbeahpage()
//
//}