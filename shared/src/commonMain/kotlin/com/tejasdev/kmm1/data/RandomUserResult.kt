package com.tejasdev.kmm1.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomUserResult(
    @SerialName("info")
    val info: Info,
    @SerialName("results")
    val results: List<Result>
)