package com.bangkit.riskque.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuestionViewModel : ViewModel() {

    private val _questNumber = MutableLiveData(0)
    val questNumber: LiveData<Int> get() = _questNumber

    private val _point = MutableLiveData(arrayOf(0, 0, 0, 0, 0, 0, 0, 0))
    private val point: LiveData<Array<Int>> get() = _point

    fun getPrev() {
        _questNumber.value = _questNumber.value?.minus(1)
    }

    fun getNext() {
        _questNumber.value = _questNumber.value?.plus(1)
    }

    fun setPoint(point: Int) {
        _point.value?.set(_questNumber.value!!, point)
    }

    fun getTotalPoint(): Int {
        var result = 0
        for (num in point.value!!) {
            result += num
        }
        result -= (point.value!![6] + point.value!![7])
        return result
    }
}