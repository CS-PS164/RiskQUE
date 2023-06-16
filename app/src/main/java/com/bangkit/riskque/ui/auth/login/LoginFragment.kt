package com.bangkit.riskque.ui.auth.login

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.bangkit.riskque.R
import com.bangkit.riskque.data.local.SettingPreferences
import com.bangkit.riskque.data.local.dataStore
import com.bangkit.riskque.databinding.FragmentLoginBinding
import com.bangkit.riskque.ui.auth.AuthActivity
import com.bangkit.riskque.ui.auth.register.RegisterFragment
import com.bangkit.riskque.ui.setting.SettingViewModel
import com.bangkit.riskque.ui.setting.SettingViewModelFactory
import com.google.android.material.snackbar.Snackbar

class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var email: String
    private lateinit var password: String
    private var hidePass = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pref = SettingPreferences.getInstance((activity as AuthActivity).dataStore)
        val settingViewModel = ViewModelProvider(
            requireActivity(), SettingViewModelFactory(pref)
        )[SettingViewModel::class.java]

        editTextListener()

        loginViewModel.apply {
            isLoading.observe(viewLifecycleOwner) {
                showLoading(it)
            }
            isButtonEnable.observe(viewLifecycleOwner) {
                binding.btnLogin.isEnabled = it
            }

        }
        binding.apply {

            btnSeePass.setOnClickListener {
                setVisibilityPassword()
                if (!hidePass) {
                    it.setBackgroundResource(R.drawable.ic_eye_open)
                } else {
                    it.setBackgroundResource(R.drawable.ic_eye_off)
                }
            }

            btnLogin.setOnClickListener {
                email = etLoginEmail.text.toString()
                password = etLoginPassword.text.toString()
                loginViewModel.apply {
                    login(email, password)
                    loginResponse.observe(viewLifecycleOwner) {
                        settingViewModel.saveLoginSession(it.loginResult.token)
                        moveToQuestActivity()
                    }
                    isError.observe(viewLifecycleOwner) {
                        showError(it)
                    }
                }
            }

            tvRegister.setOnClickListener {
                moveToRegister()
            }
        }
    }

    private fun setVisibilityPassword() {
        binding.etLoginPassword.apply {
            transformationMethod =
                if (hidePass) HideReturnsTransformationMethod.getInstance() else PasswordTransformationMethod.getInstance()
            setSelection(this.length())
        }
        hidePass = !hidePass
    }

    private fun moveToRegister() {
        val registerFragment = RegisterFragment()
        val fragmentManager = parentFragmentManager

        fragmentManager.beginTransaction().apply {
            replace(R.id.frame_container, registerFragment, RegisterFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }

    private fun moveToQuestActivity() {
        (activity as AuthActivity).moveToRiskTypeActivity()
    }

    private fun editTextListener() {

        binding.etLoginEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                loginViewModel.apply {
                    setEmailOk(binding.etLoginEmail.isEmailOk())
                    isButtonEnable()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.etLoginPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnSeePass.visibility = if (p0?.length != 0) View.VISIBLE else View.GONE
                loginViewModel.apply {
                    setPassOk(binding.etLoginPassword.isPassOk())
                    isButtonEnable()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    override fun onResume() {
        super.onResume()
        loginViewModel.apply {
            setEmailOk(binding.etLoginEmail.isEmailOk())
            setPassOk(binding.etLoginPassword.isPassOk())
            isButtonEnable()
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
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