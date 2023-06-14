package com.bangkit.riskque.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.FragmentProfileBinding
import com.bangkit.riskque.databinding.FragmentSearchBinding
import com.bangkit.riskque.ui.auth.AuthActivity
import com.bangkit.riskque.ui.main.MainActivity

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            llUserInfo.setOnClickListener {
                (activity as MainActivity).moveToUserInformationActivity()
            }
            llSetting.setOnClickListener {
                (activity as MainActivity).moveToSettingActivity()
            }
            llFaq.setOnClickListener {
                (activity as MainActivity).moveToFaqActivity()
            }
            llLogOut.setOnClickListener {

            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}