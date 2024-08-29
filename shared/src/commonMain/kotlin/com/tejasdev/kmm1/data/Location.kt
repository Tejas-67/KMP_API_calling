package com.tejasdev.kmm1.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("city")
    val city: String,
    @SerialName("coordinates")
    val coordinates: Coordinates,
    @SerialName("country")
    val country: String,
    @SerialName("state")
    val state: String,
    @SerialName("street")
    val street: Street,
    @SerialName("timezone")
    val timezone: Timezone
)