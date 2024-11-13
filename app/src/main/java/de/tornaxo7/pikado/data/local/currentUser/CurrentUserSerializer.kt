package de.tornaxo7.pikado.data.local.currentUser

import androidx.datastore.core.Serializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

object CurrentUserSerializer : Serializer<CurrentUser> {
    override val defaultValue: CurrentUser
        get() = CurrentUser()

    override suspend fun readFrom(input: InputStream): CurrentUser {
        return try {
            Json.decodeFromString(
                deserializer = CurrentUser.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: CurrentUser, output: OutputStream) {
        withContext(Dispatchers.IO) {
            output.write(
                Json.encodeToString(
                    serializer = CurrentUser.serializer(),
                    value = t
                ).encodeToByteArray()
            )
        }
    }

}