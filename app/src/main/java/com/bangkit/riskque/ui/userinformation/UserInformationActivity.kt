package com.bangkit.riskque.ui.userinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.riskque.databinding.ActivityUserInformationBinding

class UserInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
    }
}