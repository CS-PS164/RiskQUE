package com.bangkit.riskque.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bangkit.riskque.data.DplkRepository
import com.bangkit.riskque.di.Injection
import com.bangkit.riskque.model.Dplk

class HomeViewModel(private val dplkRepository: DplkRepository) : ViewModel() {

    fun getListDplk(token: String): LiveData<PagingData<Dplk>> {
        return dplkRepository.getStory(token).cachedIn(viewModelScope)
    }
}

class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(Injection.provideRepository(context)) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}