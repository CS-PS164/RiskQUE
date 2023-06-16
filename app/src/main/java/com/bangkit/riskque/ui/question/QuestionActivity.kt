package com.bangkit.riskque.ui.question

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        viewModel.questNumber.observe(this) { index ->
            quest = generateDataQuestion(index)

            binding.apply {
                tvPageNumber.text = "${index + 1}"

                btnPrev.apply {
                    setOnClickListener {
                        viewModel.getPrev()
                        setCheckRadioButton(viewModel.getPoint(index))
                    }
                    visibility = if (index != 0) View.VISIBLE else View.GONE
                }

                btnNext.apply {
                    if (index != 7) {
                        tvQuestNumber.setTextColor(getColor(R.color.black))
                        tvPageNumber.setTextColor(getColor(R.color.black))
                        text = resources.getString(R.string.selanjutnya)
                        setOnClickListener {
                            rgQuestion.clearCheck()
                            viewModel.getNext()
                            isEnabled = false
                        }
                    } else {
                        tvQuestNumber.setTextColor(getColor(R.color.sea))
                        tvPageNumber.setTextColor(getColor(R.color.sea))
                        text = resources.getString(R.string.selesai)
                        setOnClickListener {
                            moveToRiskTypeActivity(viewModel.getTotalPoint())
                        }
                    }
                }
                tvQuestion.text = quest.quest

                if (index < 5) {
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

    private fun setCheckRadioButton(point: Int) {
        binding.apply {
            btnNext.isEnabled = true
            when (point) {
                1 -> rbAnswer1.isChecked = true
                2 -> rbAnswer2.isChecked = true
                3 -> rbAnswer3.isChecked = true
                4 -> rbAnswer4.isChecked = true
                5 -> rbAnswer5.isChecked = true
            }
        }

    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            //active next btn
            binding.btnNext.isEnabled = true

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