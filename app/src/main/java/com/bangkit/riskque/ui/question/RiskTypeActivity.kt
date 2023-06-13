package com.bangkit.riskque.ui.question

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.bangkit.riskque.databinding.ActivityRiskTypeBinding

class RiskTypeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRiskTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRiskTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}