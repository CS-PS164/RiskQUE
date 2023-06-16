package com.bangkit.riskque.ui.predict

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.FragmentPredictBinding
import com.google.android.material.snackbar.Snackbar

class PredictFragment : Fragment() {

    private var _binding: FragmentPredictBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPredictBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            checkEditText()
            btnPredict.setOnClickListener {
                //panggil model
                if (checkEditText()){
                    predictResult.visibility = View.VISIBLE
                    ivRiskType.setImageResource(R.drawable.ic_moderat)
                    tvResult.text = "Moderat"
                    it.visibility = View.GONE
                } else {
                    showError("Field harus diisi semua")
                }
            }
            predictResult.setOnClickListener {
                clearDataEditText()
                it.visibility = View.GONE
            }
        }
    }

    private fun checkEditText(): Boolean {
        var isEditTextOk = false
        binding.apply {
            if (etMoneyMarket.text.isNotEmpty() && etObligation.text.isNotEmpty() &&
                etStock.text.isNotEmpty() && etMonth1.text.isNotEmpty() &&
                etMonth3.text.isNotEmpty() && etMonth6.text.isNotEmpty() &&
                etYear1.text.isNotEmpty() && etYear3.text.isNotEmpty() &&
                etYear5.text.isNotEmpty() && etAum.text.isNotEmpty()
            ) {
                isEditTextOk = true
            }
            return isEditTextOk
        }
    }

    fun clearDataEditText(){
        binding.apply {
            etMoneyMarket.text.clear()
            etObligation.text.clear()
            etStock.text.clear()
            etMonth1.text.clear()
            etMonth3.text.clear()
            etMonth6.text.clear()
            etYear1.text.clear()
            etYear3.text.clear()
            etYear5.text.clear()
            etAum.text.clear()
        }
    }

    private fun showError(text: String) {
        Snackbar.make(
            binding.root, text, Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}