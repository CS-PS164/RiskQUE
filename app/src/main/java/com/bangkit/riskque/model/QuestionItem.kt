package com.bangkit.riskque.model

data class Quest(
    val quest: String,
    val option: List<Answer>
)

data class Answer(
    val answer: String
)
