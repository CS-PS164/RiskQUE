package com.bangkit.riskque.ui.profile

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bangkit.riskque.data.local.SettingPreferences
import com.bangkit.riskque.data.local.dataStore
import com.bangkit.riskque.databinding.FragmentProfileBinding
import com.bangkit.riskque.ui.auth.AuthActivity
import com.bangkit.riskque.ui.main.MainActivity
import com.bangkit.riskque.ui.setting.SettingViewModel
import com.bangkit.riskque.ui.setting.SettingViewModelFactory

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
                logOut()
            }

        }
    }

    private fun logOut() {

        val pref = SettingPreferences.getInstance((activity as MainActivity).dataStore)
        val settingViewModel = ViewModelProvider(
            requireActivity(), SettingViewModelFactory(pref)
        )[SettingViewModel::class.java]

        val mBuilder = AlertDialog.Builder(requireContext()).setTitle("Log Out")
            .setMessage("Apakah anda yakin ingin log out?").setPositiveButton("Ya", null)
            .setNegativeButton("Tidak", null).show()

        val mPositiveButton = mBuilder.getButton(AlertDialog.BUTTON_POSITIVE)
        mPositiveButton.setOnClickListener {
            settingViewModel.clearLoginSession()
            moveToAuthActivity()
        }
    }

    private fun moveToAuthActivity() {
        (activity as MainActivity).moveToAuthActivity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}