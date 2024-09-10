package com.ezgiyilmaz.compose2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            sayfaGecis()
        }
    }
    @Composable
    fun sayfaGecis(){
        val navController= rememberNavController()
        NavHost(navController, startDestination = "anasayfa"){
            composable("anasayfa") {
                AnaSayfa(navController)
            }
            composable("tahmin_ekrani") {
                TahminEkrani(navController)
            }
            //SONUÇ EKRANINDA VERİ ALMA İŞLEMİ
            composable("sonuc_ekrani/{sonuc}",
                arguments = listOf( // belirttiğmiz ifade sonuc yer alıyor bunu alıp Sonuc ekranına göndericez
                navArgument("sonuc"){type=NavType.BoolType} // türü tanımladık ismini belirttik
            )) {
                val sonuc=it.arguments?.getBoolean("sonuc")!!
                SonucEkrani(navController,sonuc)
            }
        }
    }
    @Composable
    fun AnaSayfa(navController: NavController) {
        Column(modifier = Modifier.fillMaxSize(),
            horizontalAlignment=Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly)
        {
            Text(text="Tahmin Oyunu")
            Image(painter = painterResource(id=R.drawable.zar_resim), contentDescription = "açıklama")
            Button(onClick = {navController.navigate("tahmin_ekrani") }){
                Text(text="Oyuna Başla",
                    modifier = Modifier.size(width = 250.dp, height = 50.dp))
            }
        }
    }
}
