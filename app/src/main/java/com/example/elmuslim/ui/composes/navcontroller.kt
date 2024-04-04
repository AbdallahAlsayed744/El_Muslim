package com.example.elmuslim.ui.composes

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.elmuslim.utilis.constants
import com.example.elmuslim.viewmodels2.onbording_viwmodel


@Composable
fun navcontroller(startrdistination:String) {

    val navcontroller= rememberNavController()

    NavHost(navController = navcontroller, startDestination = startrdistination ){

        composable(route=constants.welcomepage){
           val model : onbording_viwmodel = hiltViewModel()
            StartScreen(model::myevent)

        }
        composable(route=constants.startpage){
            Homepage({
                navcontroller.navigate(constants.quranpage)
            },{navcontroller.navigate(constants.ahadispage)},{
                navcontroller.navigate(constants.tasbeehpage)
            },{navcontroller.navigate(constants.QuranListining)})
        }
        composable(route=constants.quranpage){
            quranpage(navcontroller)

        }

        composable(route="${constants.ayapag}/{id}/{name}", arguments = listOf(
            navArgument("id"){
                type= NavType.StringType
            },
            navArgument("name"){
                type= NavType.StringType
            }
        )
        )
        {
            val id=it.arguments?.getString("id")
            val name=it.arguments?.getString("name")
            Ayat_page(navController = navcontroller,id,name)
        }

        composable(route=constants.ahadispage){
            Hadispage(navcontroller)
        }

        composable(route="${constants.spasfichadispage}/{hadis}", arguments = listOf(
            navArgument("hadis"){
                type= NavType.StringType
            }
        )){
            val hadis = it.arguments?.getString("hadis")
           Spasfichadis(hadis,navcontroller)
        }
        composable(route=constants.tasbeehpage){
            Tasbeahpage(navcontroller)
        }
        composable(route=constants.QuranListining){
            QuranListining(navcontroller)
        }
        composable(route="${constants.Suwarforreciters}/{server}", arguments = listOf(
            navArgument("server"){
                type= NavType.StringArrayType
            }
        ))
        {
            val serv =it.arguments?.getStringArray("server")?.toList()?.toTypedArray()?: emptyArray()
            Suwarforreciters(navcontroller,serv)
        }
    }


}