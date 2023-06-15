package com.bangkit.riskque.ui.setting

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.bangkit.riskque.data.local.SettingPreferences
import kotlinx.coroutines.launch

class SettingViewModel(private val pref: SettingPreferences) : ViewModel() {
    fun getThemeSettings(): LiveData<Boolean> {
        return pref.getThemeSetting().asLiveData()
    }

    fun saveThemeSetting(isDarkModeActive: Boolean) {
        viewModelScope.launch {
            pref.saveThemeSetting(isDarkModeActive)
        }
    }

    fun getTokenUser(): LiveData<String?> = pref.getUserToken().asLiveData()

    fun saveLoginSession(token: String) {
        viewModelScope.launch {
            pref.saveLoginSession(token)
        }
    }

    fun clearLoginSession() {
        viewModelScope.launch {
            pref.clearLoginSession()
        }
    }
}