package com.bangkit.riskque.ui.predict

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.FragmentPredictBinding
import com.bangkit.riskque.databinding.FragmentSearchBinding

class PredictFragment : Fragment() {

    private var _binding: FragmentPredictBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPredictBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}