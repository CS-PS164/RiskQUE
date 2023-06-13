package com.bangkit.riskque.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionViewModel: ViewModel() {

    private val _questNumber = MutableLiveData(0)
    val questNumber: LiveData<Int> get() = _questNumber

    private val _point = MutableLiveData<ArrayList<Int>>()
    val point: LiveData<ArrayList<Int>> get() = _point

    fun getPrev(){
        _questNumber.value = _questNumber.value?.minus(1)
    }

    fun getNext(){
        _questNumber.value = _questNumber.value?.plus(1)
    }
}