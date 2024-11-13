package de.tornaxo7.pikado.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.serialization.kotlinx.json.json

class VikunjaApi {
    private lateinit var client: HttpClient

    companion object {
        const val API_SUFFIX: String = "/api/v1"
    }

    constructor(
        serverUrl: String,
        loadTokens: (client: HttpClient) -> BearerTokens,
        refreshTokens: (client: HttpClient) -> BearerTokens
    ) {
        client = HttpClient(CIO) {
            install(Auth) {
                bearer {
                    loadTokens {
                        loadTokens(client)
                    }
                    refreshTokens {
                        refreshTokens(client)
                    }
                }
            }

            defaultRequest {
                url("${serverUrl}${API_SUFFIX }")
            }

            install(ContentNegotiation) {
                json()
            }
        }
    }
}