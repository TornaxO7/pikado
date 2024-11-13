package de.tornaxo7.pikado.data.network

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val token: String
)
