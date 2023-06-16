package com.bangkit.riskque.model

data class Quest(
    val image: Int,
    val quest: String,
    val option: List<Answer>
)

data class Answer(
    val answer: String
)
