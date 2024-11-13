package de.tornaxo7.pikado

import android.content.Context
import androidx.datastore.dataStore
import de.tornaxo7.pikado.data.VikunjaRepository
import de.tornaxo7.pikado.data.local.currentUser.CurrentUserSerializer
import de.tornaxo7.pikado.data.local.user.UserDatabase
import de.tornaxo7.pikado.data.network.VikunjaApi

val Context.currentUser by dataStore("current_user.json", CurrentUserSerializer)

class Container(context: Context) {
    val vikunjaRepository by lazy {
        VikunjaRepository(
            api = VikunjaApi(),
            userDatabase = UserDatabase.getDatabase(context).userDao(),
            currentUser = context.currentUser,
        )
    }
}