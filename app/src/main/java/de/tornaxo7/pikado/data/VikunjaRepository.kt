package de.tornaxo7.pikado.data

import androidx.datastore.core.DataStore
import de.tornaxo7.pikado.data.local.currentUser.CurrentUser
import de.tornaxo7.pikado.data.local.user.UserDao
import de.tornaxo7.pikado.data.network.VikunjaApi
import kotlinx.coroutines.flow.first

class VikunjaRepository(
    private val api: VikunjaApi,
    private val userDatabase: UserDao,
    private val currentUser: DataStore<CurrentUser>
) {

    suspend fun isLoggedIn(): Boolean {
        return !currentUser.data.first().token.isNullOrEmpty()
    }
}