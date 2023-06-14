package com.bangkit.riskque.ui.faq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.ActivityFaqBinding

class FaqActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFaqBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFaqBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}