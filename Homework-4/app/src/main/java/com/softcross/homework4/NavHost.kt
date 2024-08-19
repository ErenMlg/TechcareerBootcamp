package com.softcross.homework4

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navHostController,
        startDestination = Anasayfa.route,
        modifier = modifier
    ){
        composable(Anasayfa.route){
            Anasayfa(
                onClickA = {
                    navHostController.navigate(ASayfasi.route)
                },
                onClickX = {
                    navHostController.navigate(XSayfasi.route)
                }
            )
        }
        composable(ASayfasi.route){
            ASayfasi(
                onClickB = {
                    navHostController.navigate(BSayfasi.route)
                },
            )
        }
        composable(BSayfasi.route){
            BSayfasi(
                onClickY = {
                    navHostController.navigate(YSayfasi.route)
                }
            )
        }
        composable(XSayfasi.route){
            XSayfasi(
                onClickY = {
                    navHostController.navigate(YSayfasi.route)
                }
            )
        }
        composable(YSayfasi.route){
            YSayfasi(
                onBack = {
                    navHostController.navigate(Anasayfa.route)
                }
            )
        }
    }
}