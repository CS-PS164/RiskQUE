package com.bangkit.riskque.ui.question

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.ActivityRiskTypeBinding
import com.bangkit.riskque.ui.main.MainActivity
import com.bangkit.riskque.utils.Constants

class RiskTypeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRiskTypeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRiskTypeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val point = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getIntExtra(Constants.EXTRA_POINT, 0)
        } else {
            intent.getIntExtra(Constants.EXTRA_POINT, 0)
        }

        if (point != 0) {
            binding.apply {
                llSafety.visibility = View.GONE
                btnSave.visibility = View.VISIBLE
                if (point < 14) {
                    tvQuestionTitle.text = resources.getString(R.string.konservatif)
                    tvQuestionDescription.text = resources.getString(R.string.konservatif_definition)
                } else if (point < 23) {
                    tvQuestionTitle.text = resources.getString(R.string.moderat)
                    tvQuestionDescription.text = resources.getString(R.string.moderat_definition)
                } else {
                    tvQuestionTitle.text = resources.getString(R.string.agresif)
                    tvQuestionDescription.text = resources.getString(R.string.agresif_definition)
                }
            }
        }

        binding.apply {
            btnStart.setOnClickListener {
                moveToQuestionActivity()
            }
            btnSave.setOnClickListener {
                moveToMainActivity()
            }
        }
    }

    private fun moveToQuestionActivity() {
        startActivity(Intent(this, QuestionActivity::class.java))
        finish()
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}