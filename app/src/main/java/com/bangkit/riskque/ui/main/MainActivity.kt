package com.bangkit.riskque.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.ActivityMainBinding
import com.bangkit.riskque.ui.auth.AuthActivity
import com.bangkit.riskque.ui.faq.FaqActivity
import com.bangkit.riskque.ui.question.RiskTypeActivity
import com.bangkit.riskque.ui.setting.SettingActivity
import com.bangkit.riskque.ui.userinformation.UserInformationActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment)
        binding.navView.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, NavDest: NavDestination, _ ->
            if (NavDest.id == R.id.navigation_home || NavDest.id == R.id.navigation_predict
                || NavDest.id == R.id.navigation_profile
            ) {
                binding.navView.visibility = View.VISIBLE
            } else {
                binding.navView.visibility = View.GONE
            }
        }
    }
    fun moveToAuthActivity() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }

    fun moveToUserInformationActivity() {
        startActivity(Intent(this, UserInformationActivity::class.java))
    }

    fun moveToSettingActivity() {
        startActivity(Intent(this, SettingActivity::class.java))
    }

    fun moveToFaqActivity() {
        startActivity(Intent(this, FaqActivity::class.java))
    }

}