package com.example.elmuslim.ui.composes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun circularandicator(modifier: Modifier = Modifier, background1: Color, background2: Color, background3: Color) {

    Row (modifier = Modifier.padding(top = 20.dp), horizontalArrangement = Arrangement.spacedBy(2.dp)){
        Box (modifier = Modifier
            .size(10.dp)
            .clip(CircleShape)
            .background(background1)){

        }
        Box (modifier = Modifier
            .size(10.dp)
            .clip(CircleShape)
            .background(background2)){

        }
        Box (modifier = Modifier
            .size(10.dp)
            .clip(CircleShape)
            .background(background3)){

        }

    }
}
