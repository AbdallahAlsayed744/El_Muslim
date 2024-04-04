package com.example.elmuslim.ui.composes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.elmuslim.R
import com.example.elmuslim.ui.theme.amiri_bold

@Composable
fun Spasfichadis(hadis:String?,navController: NavController) {
//    val state by model.spasficvalue.observeAsState()
    Column(modifier = Modifier.fillMaxSize()) {
        Box (modifier = Modifier.fillMaxSize()) {
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
                    text = "",
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
            Image(painter = painterResource(id = R.drawable.hadis), contentDescription ="",
                modifier = Modifier.padding(top = 150.dp).fillMaxWidth(), alignment = Alignment.Center

            )


                Spasficbody(hadis.toString())


        }
    }

}



@Composable
fun Spasficbody(hadis: String?) {

        Text(text = hadis.toString(), modifier = Modifier.padding(top = 219.dp, start = 10.dp, end = 10.dp), fontSize = 23.sp, fontFamily = amiri_bold)



    }
