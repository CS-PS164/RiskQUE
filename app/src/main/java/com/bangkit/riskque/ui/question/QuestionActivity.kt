package com.bangkit.riskque.ui.question

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.RadioButton
import androidx.activity.viewModels
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.ActivityQuestionBinding
import com.bangkit.riskque.model.Quest
import com.bangkit.riskque.utils.Constants
import com.bangkit.riskque.utils.DataDummy.generateDataQuestion

class QuestionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityQuestionBinding
    private val viewModel: QuestionViewModel by viewModels()

    private lateinit var quest: Quest

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPrev.setOnClickListener {
            viewModel.getPrev()
        }

        viewModel.questNumber.observe(this) {
            quest = generateDataQuestion(it)

            binding.apply {
                tvPageNumber.text = "${it + 1}"

                btnPrev.visibility = if (it != 0) View.VISIBLE else View.GONE

                if (it != 7) {
                    btnNext.text = resources.getString(R.string.selanjutnya)
                    btnNext.setOnClickListener {
                        rgQuestion.clearCheck()
                        viewModel.getNext()
                    }
                } else {
                    btnNext.text = resources.getString(R.string.selesai)
                    btnNext.setOnClickListener {
                        Log.e("total point", viewModel.getTotalPoint().toString())
                        moveToRiskTypeActivity(viewModel.getTotalPoint())
                    }
                }


                tvQuestion.text = quest.quest

                if (it < 5) {
                    rbAnswer1.text = quest.option[0].answer
                    rbAnswer2.text = quest.option[1].answer
                    rbAnswer3.text = quest.option[2].answer
                    rbAnswer4.text = quest.option[3].answer
                    rbAnswer5.text = quest.option[4].answer
                } else {
                    rbAnswer1.text = quest.option[0].answer
                    rbAnswer3.text = quest.option[1].answer
                    rbAnswer5.text = quest.option[2].answer

                    rbAnswer2.visibility = View.GONE
                    rbAnswer4.visibility = View.GONE
                }
            }
        }
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rb_answer_1 ->
                    if (checked) {
                        viewModel.setPoint(1)
                    }
                R.id.rb_answer_2 ->
                    if (checked) {
                        viewModel.setPoint(2)
                    }
                R.id.rb_answer_3 ->
                    if (checked) {
                        viewModel.setPoint(3)
                    }
                R.id.rb_answer_4 ->
                    if (checked) {
                        viewModel.setPoint(4)
                    }
                R.id.rb_answer_5 ->
                    if (checked) {
                        viewModel.setPoint(5)
                    }
            }
        }
    }

    private fun moveToRiskTypeActivity(totalPoint: Int) {
        val intentRiskType = Intent(this, RiskTypeActivity::class.java)
        intentRiskType.putExtra(Constants.EXTRA_POINT, totalPoint)
        startActivity(intentRiskType)

        finish()
    }
}