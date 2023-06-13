package com.bangkit.riskque.ui.onboard

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.bangkit.riskque.R
import com.bangkit.riskque.adapter.OnBoardAdapter
import com.bangkit.riskque.databinding.ActivityOnBoardBinding
import com.bangkit.riskque.model.OnBoardItem
import com.bangkit.riskque.ui.auth.AuthActivity

class OnBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOnBoardBinding
    private lateinit var onBoardAdapter: OnBoardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBoardAdapter = OnBoardAdapter(setOnBoardItems())

        binding.apply {
            vpOnBoard.adapter = onBoardAdapter
            binding.diOnBoard.attachTo(binding.vpOnBoard)
        }

        binding.apply {
            btnSkip.setOnClickListener {
                moveToAuthActivity()
            }
            btnStart.setOnClickListener {
                moveToAuthActivity()
            }
        }

        binding.vpOnBoard.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)

                binding.btnNext.setOnClickListener {
                    binding.vpOnBoard.setCurrentItem(position+1, true)
                }
                if (position == 2) {
                    binding.apply {
                        btnSkip.visibility = View.GONE
                        btnNext.visibility = View.GONE
                        btnStart.visibility = View.VISIBLE
                    }
                }else{
                    binding.apply {
                        btnSkip.visibility = View.VISIBLE
                        btnNext.visibility = View.VISIBLE
                        btnStart.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun setOnBoardItems() : List<OnBoardItem> {
        return listOf(
            OnBoardItem(
                R.drawable.on_board_1,getString(R.string.title1), getString(R.string.description1)
            ), OnBoardItem(
                R.drawable.on_board_2,getString(R.string.title2), getString(R.string.description2)
            ), OnBoardItem(
                R.drawable.on_board_3,getString(R.string.title3), getString(R.string.description3)
            )
        )
    }

    fun moveToAuthActivity() {
        startActivity(Intent(this, AuthActivity::class.java))
        finish()
    }
}