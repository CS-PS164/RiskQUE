package com.bangkit.riskque.ui.auth.register

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.FragmentRegisterBinding
import com.bangkit.riskque.ui.auth.login.LoginFragment
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : Fragment() {

    private val authViewModel: RegisterViewModel by activityViewModels()
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var email: String
    private lateinit var password: String
    private lateinit var username: String
    private var hidePass = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editTextListener()

        authViewModel.apply {
            isLoading.observe(viewLifecycleOwner) {
                showLoading(it)
            }
            isButtonEnable.observe(viewLifecycleOwner) {
                binding.btnRegister.isEnabled = it
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

            btnRegister.setOnClickListener {
                email = etRegisterEmail.text.toString()
                password = etRegisterPassword.text.toString()
                username = etRegisterUsername.text.toString()

                authViewModel.apply {
                    register(username, email, password)
                    registerResponse.observe(viewLifecycleOwner) {
                        moveToLogin()
                    }
                    isError.observe(viewLifecycleOwner) {
                        showError(it)
                    }
                }
            }
        }
    }

    private fun setVisibilityPassword() {
        binding.etRegisterPassword.apply {
            transformationMethod =
                if (hidePass) HideReturnsTransformationMethod.getInstance() else PasswordTransformationMethod.getInstance()
            setSelection(this.length())
        }
        hidePass = !hidePass
    }

    private fun moveToLogin() {
        val loginFragment = LoginFragment()
        val fragmentManager = parentFragmentManager

        fragmentManager.beginTransaction().apply {
            replace(R.id.frame_container, loginFragment, LoginFragment::class.java.simpleName)
            addToBackStack(null)
            commit()
        }
    }

    private fun editTextListener() {
        binding.etRegisterUsername.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                authViewModel.apply {
                    setNameOk(binding.etRegisterUsername.isNameOk())
                    isButtonEnable()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.etRegisterEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                authViewModel.apply {
                    setEmailOk(binding.etRegisterEmail.isEmailOk())
                    isButtonEnable()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        binding.etRegisterPassword.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.btnSeePass.visibility = if (p0?.length != 0) View.VISIBLE else View.GONE
                authViewModel.apply {
                    setPassOk(binding.etRegisterPassword.isPassOk())
                    isButtonEnable()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
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