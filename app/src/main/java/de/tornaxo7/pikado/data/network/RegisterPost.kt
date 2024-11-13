package de.tornaxo7.pikado.data.network

import kotlinx.serialization.Serializable

@Serializable
data class RegisterPost(
    val email: String,
    val id: Int,
    val password: String,
    val username: String,
)
