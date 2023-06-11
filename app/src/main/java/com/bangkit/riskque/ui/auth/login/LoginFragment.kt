package com.bangkit.riskque.ui.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.FragmentLoginBinding
import com.bangkit.riskque.ui.auth.AuthActivity
import com.bangkit.riskque.ui.auth.register.RegisterFragment

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private lateinit var email: String
    private lateinit var password: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {

            btnLogin.setOnClickListener {
                email = etLoginEmail.text.toString()
                password = etLoginPassword.text.toString()
                login(email, password)
            }

            btnGoogle.setOnClickListener {

            }

            tvRegister.setOnClickListener {
                moveToRegister()
            }
        }
    }

    private fun login(email: String, password: String) {
        moveToMainActivity()
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

    private fun moveToMainActivity() {
        (activity as AuthActivity).moveToMainActivity()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}