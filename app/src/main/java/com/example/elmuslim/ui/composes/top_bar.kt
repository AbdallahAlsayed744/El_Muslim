package com.example.elmuslim.ui.composes

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elmuslim.R
import com.example.elmuslim.ui.theme.amiri_bold
import com.example.elmuslim.ui.theme.poppeni_bold

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun topbar(text:String,onclickmenue:()->Unit,onclicksearch:()->Unit) {
    Scaffold(
        topBar ={
        TopAppBar(modifier = Modifier.fillMaxWidth(),title = {
            Text(text = text, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center ,fontSize = 27.sp, fontFamily = poppeni_bold, color = colorResource(id = R.color.muslim))
        },

            navigationIcon = {
                IconButton(onClick = { onclickmenue()}) {
                    Icon(painter = painterResource(id = R.drawable.baseline_menu_24) , contentDescription ="" )


                }
            },
            actions = {
                IconButton(onClick = { onclicksearch()}) {
                    Icon(painter = painterResource(id = R.drawable.search) , contentDescription ="" )


                }

            }

        )

}

    ) {


    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quranpage_topbar(text:String,onclickmenue:()->Unit,onclicksearch:()->Unit) {
    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier.fillMaxWidth(), title = {
                Text(
                    text = text,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 27.sp,
                    fontFamily = poppeni_bold,
                    color = colorResource(id = R.color.muslim)
                )
            },

                navigationIcon = {
                    IconButton(onClick = { onclickmenue() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                            contentDescription = ""
                        )


                    }
                },
                actions = {
                    IconButton(onClick = { onclicksearch() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.search),
                            contentDescription = ""
                        )


                    }

                }

            )
        }

    )
    {

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun topbar_ayat(text:String,onclickmenue:()->Unit,onclicksearch:()->Unit) {
    Box(modifier = Modifier) {
        Image(
            painter = painterResource(id = R.drawable.quran),
            contentDescription = "",
            modifier = Modifier
                .width(40.dp)
                .height(40.dp),
            contentScale = ContentScale.Crop,
            alignment = Alignment.TopStart
        )


        Scaffold(

            topBar = {
                TopAppBar(
                    modifier = Modifier.fillMaxWidth(),
                    title = {
                        Text(
                            text = text,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp,
                            fontFamily = amiri_bold,
                            color = colorResource(id = R.color.muslim)
                        )
                    },


                    navigationIcon = {
                        IconButton(onClick = { onclickmenue() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_arrow_back_24),
                                contentDescription = ""
                            )


                        }
                    },
                    actions = {
                        IconButton(onClick = { onclicksearch() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_more_vert_24),
                                contentDescription = ""
                            )


                        }

                    },


                )

            }

        ) {

//            Image(painter = painterResource(id = R.drawable.quran), contentDescription = "",modifier = Modifier.height(24.dp).padding(30.dp))


        }
    }
}