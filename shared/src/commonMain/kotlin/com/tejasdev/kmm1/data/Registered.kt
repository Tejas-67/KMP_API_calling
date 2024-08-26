package com.tejasdev.kmm1.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Registered(
    @SerialName("age")
    val age: Int,
    @SerialName("date")
    val date: String
)