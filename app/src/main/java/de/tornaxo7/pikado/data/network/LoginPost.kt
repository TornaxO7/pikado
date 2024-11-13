package de.tornaxo7.pikado.data.network

import kotlinx.serialization.Serializable

@Serializable
data class LoginPost(
    val long_token: Boolean,
    val password: String,
    val totp_passcode: String,
    val username: String
)
