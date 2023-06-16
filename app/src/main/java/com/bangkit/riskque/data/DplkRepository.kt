package com.bangkit.riskque.data

import androidx.lifecycle.LiveData
import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.bangkit.riskque.data.local.DplkDatabase
import com.bangkit.riskque.data.remote.ApiService
import com.bangkit.riskque.model.Dplk

class DplkRepository(private val dplkDatabase: DplkDatabase, private val apiService: ApiService) {
    @OptIn(ExperimentalPagingApi::class)
    fun getDplk(token: String): LiveData<PagingData<Dplk>> {
        return Pager(
            config = PagingConfig(
                pageSize = 5
            ),
            remoteMediator = DplkRemoteMediator(dplkDatabase, apiService, token),
            pagingSourceFactory = {
                dplkDatabase.dplkDao().getAllDplk()
            }
        ).liveData
    }
}