package com.ezgiyilmaz.compose2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun SonucEkrani(navController: NavController,gelenSonuc:Boolean) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment= Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly)
    {
        if(gelenSonuc){
            Text(text="Kazandınız")
            Image(painter = painterResource(id=R.drawable.mutlu_resim), contentDescription = "açıklama")
        }
        else{
            Text(text="Kaybettiniz")
            Image(painter = painterResource(id=R.drawable.uzgun_resim), contentDescription = "açıklama")
        }
    }
}