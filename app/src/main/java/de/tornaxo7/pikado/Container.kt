package de.tornaxo7.pikado

import android.content.Context
import de.tornaxo7.pikado.data.VikunjaRepository
import de.tornaxo7.pikado.data.local.user.UserDatabase
import de.tornaxo7.pikado.data.network.VikunjaApi

class Container(context: Context) {
    val vikunjaRepository by lazy {
        VikunjaRepository(
            api = VikunjaApi(),
            userDatabase = UserDatabase.getDatabase(context).userDao()
        )
    }
}