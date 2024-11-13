package de.tornaxo7.pikado.data.local.currentUser

import kotlinx.serialization.Serializable

@Serializable
data class CurrentUser(
    val token: String? = null,
    val serverUrl: String? = null,
)
