package com.bangkit.riskque.ui.auth.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bangkit.riskque.data.remote.ApiConfig
import com.bangkit.riskque.model.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel : ViewModel() {

    private var _isNameOk: Boolean = false
    private var _isEmailOk: Boolean = false
    private var _isPassOk: Boolean = false

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    private val _isError = MutableLiveData<String>()
    val isError: LiveData<String> = _isError

    private var _isButtonEnable = MutableLiveData<Boolean>()
    val isButtonEnable: LiveData<Boolean> get() = _isButtonEnable

    private val _registerResponse = MutableLiveData<RegisterResponse>()
    val registerResponse: LiveData<RegisterResponse> get() = _registerResponse

    fun setNameOk(isNameOk: Boolean) {
        _isNameOk = isNameOk
    }

    fun setEmailOk(isEmailOk: Boolean) {
        _isEmailOk = isEmailOk
    }

    fun setPassOk(isPassOk: Boolean) {
        _isPassOk = isPassOk
    }

    fun isButtonEnable() {
        _isButtonEnable.value = _isEmailOk && _isPassOk && _isNameOk
    }

    fun register(name: String, email: String, password: String) {
        _isLoading.value = true
        val client = ApiConfig.getApiService().doRegister(name, email, password)
        client.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>, response: Response<RegisterResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _registerResponse.value = response.body()
                } else {
                    when (response.code()) {
                        400 -> _isError.value = "invalid account"
                        401 -> _isError.value = "unauthorized"
                        else -> _isError.value = "error ${response.message()}"
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                _isLoading.value = false
                _isError.value = t.message
            }

        })
    }
}