package com.example.pokemontool

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNav: BottomNavigationView
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav = findViewById(R.id.bottom_nav)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        bottomNav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.record -> {
//                val fragment = RecordTeamSelectFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
//                    .commit()
                navController.navigate(R.id.recordTeamSelectFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.team_list -> {
//                val fragment = TeamListFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
//                    .commit()
                navController.navigate(R.id.teamListFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.history -> {
//                val fragment = HistoryFragment()
//                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
//                    .commit()
                navController.navigate(R.id.historyFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

}
