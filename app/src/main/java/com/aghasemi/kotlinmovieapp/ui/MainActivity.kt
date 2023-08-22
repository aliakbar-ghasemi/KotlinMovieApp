package com.aghasemi.kotlinmovieapp.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.aghasemi.kotlinmovieapp.R
import com.aghasemi.kotlinmovieapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        /*binding.appBar.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
            binding.toolbar.setAlpha(
                1.0f - Math.abs(verticalOffset / appBarLayout.totalScrollRange.toFloat())
            )
        })*/

        val bottomNavView: BottomNavigationView = binding.mainContent.bottomNavView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val mainPageDestinationList = listOf(
            R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
        )

        val appBarConfiguration = AppBarConfiguration.Builder(
            *mainPageDestinationList.toIntArray()
        ).build()

        setupActionBarWithNavController(navController, appBarConfiguration)
        bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            val id = destination.id
            val isMainPageDestination = mainPageDestinationList.indexOf(id) < 0
            bottomNavView.visibility = if (isMainPageDestination) View.GONE else View.VISIBLE
        }

        //update locale
        val configuration = resources.configuration
        configuration.setLayoutDirection(Locale("fa"))
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
     fun getToolbar(): Toolbar {
         return binding.toolbar
     }
}