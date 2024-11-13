package de.tornaxo7.pikado.data.local.user

import androidx.room.Entity
import io.ktor.client.plugins.auth.providers.BearerTokens

@Entity(tableName = "users", primaryKeys = ["username", "serverUrl"])
data class UserEntity(
    val username: String,
    val serverUrl: String,
    val token: String
)
