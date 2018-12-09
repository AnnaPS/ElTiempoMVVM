package com.novadev.eltiempomvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.novadev.eltiempomvvm.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Añade el toolbar
        setSupportActionBar(toolbar)

        // Componente navigation controler.
        // 1- Realizar el find View del componente
        // 2- Se configura el componente (bottom menu)
        // 3- Se añade navigation UI (flecha superior para volver hacía atrás según el menu donde estemos)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottom_nav.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this, navController)


    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(null, navController)
    }
}
