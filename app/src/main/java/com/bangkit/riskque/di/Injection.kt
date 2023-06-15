package com.bangkit.riskque.di

import android.content.Context
import com.bangkit.riskque.data.DplkRepository
import com.bangkit.riskque.data.local.DplkDatabase
import com.bangkit.riskque.data.remote.ApiConfig

object Injection {
    fun provideRepository(context: Context): DplkRepository {
        val database = DplkDatabase.getDatabase(context)
        val apiService = ApiConfig.getApiService()
        return DplkRepository(database, apiService)
    }
}