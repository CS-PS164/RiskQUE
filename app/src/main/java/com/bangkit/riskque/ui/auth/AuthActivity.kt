package com.bangkit.riskque.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.ActivityAuthBinding
import com.bangkit.riskque.ui.auth.login.LoginFragment
import com.bangkit.riskque.ui.main.MainActivity

class AuthActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val loginFragment = LoginFragment()

        fragmentManager.beginTransaction().add(R.id.frame_container, loginFragment).commit()
    }

    fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}