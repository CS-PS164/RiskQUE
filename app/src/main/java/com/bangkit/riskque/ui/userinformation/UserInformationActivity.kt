package com.bangkit.riskque.ui.userinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.ActivityUserInformationBinding

class UserInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserInformationBinding
    private var hidePass = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSeePass.setOnClickListener {
                if (hidePass) {
                    it.setBackgroundResource(R.drawable.ic_eye_open)
                    tvPassword.text = "12345678"
                } else {
                    it.setBackgroundResource(R.drawable.ic_eye_off)
                    tvPassword.text = "********"
                }
                hidePass = !hidePass
            }
            btnBack.setOnClickListener {
                onBackPressed()
            }
        }
    }
}