package com.bangkit.riskque.ui.question

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.bangkit.riskque.databinding.ActivityQuestionBinding
import com.bangkit.riskque.model.Quest
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

        viewModel.questNumber.observe(this) {
            quest = generateDataQuestion(it)

            binding.apply {
                tvPageNumber.text = "${it+1}"

                if (it == 0){
                    btnPrev.visibility = View.GONE
                }else{
                    btnPrev.visibility = View.VISIBLE
                }

                if (quest.option.size == 5){
                    tvQuestion.text = quest.quest
                    tvAnswer1.text = quest.option[0].answer
                    tvAnswer2.text = quest.option[1].answer
                    tvAnswer3.text = quest.option[2].answer
                    tvAnswer4.text = quest.option[3].answer
                    tvAnswer5.text = quest.option[4].answer
                }else{
                    tvQuestion.text = quest.quest
                    tvAnswer1.text = quest.option[0].answer
                    tvAnswer2.text = quest.option[1].answer
                    tvAnswer3.text = quest.option[2].answer

                    tvAnswer4.visibility = View.GONE
                    tvAnswer5.visibility = View.GONE
                }
            }
        }

        binding.apply {
            btnPrev.setOnClickListener {
                viewModel.getPrev()
            }
            btnNext.setOnClickListener {
                viewModel.getNext()
            }
        }
    }
}