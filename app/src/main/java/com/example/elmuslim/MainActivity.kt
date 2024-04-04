package com.example.elmuslim

import android.animation.ObjectAnimator
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AnticipateInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.elmuslim.ui.composes.StartScreen
import com.example.elmuslim.ui.composes.navcontroller
import com.example.elmuslim.ui.theme.ElMuslimTheme
import com.example.elmuslim.viewmodels2.mainviewmodel
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    val viewmodel by viewModels<mainviewmodel>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewmodel.splashcondition
            }
        }
        setContent {
            ElMuslimTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setStatusBarColor(
                        color = Color.White,
                        darkIcons = true
                    )
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val start=viewmodel.startdistination
                    navcontroller(startrdistination =start)

                }
            }

        }
    }

////    private fun insialsplashscreen() {
////        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S) {
////            // For Android 12 and higher, use the SplashScreen API
////            WindowCompat.setDecorFitsSystemWindows(window,false)
////            installSplashScreen().apply {
////                setKeepOnScreenCondition{
////                    viewmodel.splashcondition
////                }
////            }
////            splashScreen.setOnExitAnimationListener { splashscreenview ->
////                val slideup = ObjectAnimator.ofFloat(
////                    splashscreenview,
////                    View.TRANSLATION_Y,
////                    -splashscreenview.height.toFloat()
////                )
////                slideup.interpolator = AnticipateInterpolator()
////                slideup.duration = 0L
////                slideup.doOnEnd {
////                    splashscreenview.remove()
////                }
////                slideup.start()
////            }
////
////        } else {
////
////
////        }
//    }

    }

