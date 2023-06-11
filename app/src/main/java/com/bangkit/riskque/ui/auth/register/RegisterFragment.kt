package com.bangkit.riskque.ui.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bangkit.riskque.R
import com.bangkit.riskque.databinding.FragmentRegisterBinding
import com.bangkit.riskque.ui.auth.login.LoginFragment

class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private lateinit var email: String
    private lateinit var password: String
    private lateinit var username: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            btnLogin.setOnClickListener {
                email = etRegisterEmail.text.toString()
                password = etRegisterPassword.text.toString()
                username = etRegisterUsername.text.toString()

                register(email, password, username)
            }
        }
    }


    private fun register(email: String, password: String, username: String) {
        moveToLogin()
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}