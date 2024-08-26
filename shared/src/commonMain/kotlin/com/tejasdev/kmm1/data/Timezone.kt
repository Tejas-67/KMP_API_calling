package com.tejasdev.kmm1.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Timezone(
    @SerialName("description")
    val description: String,
    @SerialName("offset")
    val offset: String
)