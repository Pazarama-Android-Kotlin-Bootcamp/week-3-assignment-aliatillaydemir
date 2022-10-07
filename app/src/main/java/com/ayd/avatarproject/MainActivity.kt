package com.ayd.avatarproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationSetup()
    }


        private fun navigationSetup(){
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        }


}