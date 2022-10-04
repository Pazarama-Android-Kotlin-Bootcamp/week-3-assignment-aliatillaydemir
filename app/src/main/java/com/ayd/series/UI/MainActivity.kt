package com.ayd.series.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.ayd.series.R
import com.ayd.series.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

       val navHostController = supportFragmentManager.findFragmentById(
           R.id.fragmentContainerView
       ) as NavHostFragment  //ana host fragment'ı belirttik(bağlama işlemi yapıldı)

        navController = navHostController.navController

        val appBar = AppBarConfiguration(setOf(R.id.avatarFragment, R.id.favoriteAvatarFragment))  //app bar(bottom bar) ve sahip olduğu fragmentlar

        binding.bottomNavigationView.setupWithNavController(navController) //navgiaton bağlandı
        setupActionBarWithNavController(navController,appBar)    //bottom nav bağlantısı


        setContentView(binding.root)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

}