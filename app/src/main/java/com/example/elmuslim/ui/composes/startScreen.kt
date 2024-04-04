package com.example.elmuslim.ui.composes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.elmuslim.R
import com.example.elmuslim.ui.theme.poppeni_bold
import com.example.elmuslim.ui.theme.poppeni_regular
import com.example.elmuslim.viewmodels2.on_obordingevent


@Composable
fun StartScreen(event:(on_obordingevent)->Unit) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        startScreen2()
        textbody(text = "El Muslim")
        seconedbody(text = "Learn Quran and Recite everyday")
        Mystartutton(text = "Get Started") {
            event(on_obordingevent.saveappentry)

        }

    }

    
}


@Composable
fun startScreen2() {
    Card(
        colors = CardDefaults.cardColors(colorResource(id = R.color.card)),
        modifier = Modifier
            .width(350.dp)
            .height(450.dp)
            .padding(vertical = 10.dp)
            .clip(shape = RoundedCornerShape(15.dp))) {
        
        Image(painter = painterResource(id = R.drawable.image), contentDescription = "", modifier = Modifier.fillMaxSize())
        
    }
    
    
}
@Composable
fun textbody(text:String){
    Text(text = text, fontSize = 27.sp ,fontFamily = poppeni_bold, color = colorResource(id = R.color.text_title), modifier = Modifier.padding(vertical = 15.dp))

}

@Composable
fun seconedbody(text:String) {
    Text(
        text = text,
        fontSize = 22.sp,
        fontFamily = poppeni_regular,
        color = colorResource(id = R.color.black),
        modifier = Modifier
            .padding(bottom = 12.dp)
            .fillMaxWidth(0.5f),
        textAlign = TextAlign.Center
    )
}

@Composable
fun Mystartutton(text: String,onclick:()->Unit) {
    Button(onClick = { onclick() }, shape = RoundedCornerShape(10.dp), colors = ButtonDefaults.buttonColors(colorResource(id = R.color.text_title)), modifier = Modifier.padding(top = 20.dp)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            Text(text = text , color = colorResource(id = R.color.white), fontFamily = poppeni_regular, fontSize = 15.sp)
            Icon(painter = painterResource(id = R.drawable.baseline_arrow_forward_24), contentDescription = "")
        }



        
    }

}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun previewstart(){
//
//    StartScreen()
//}


