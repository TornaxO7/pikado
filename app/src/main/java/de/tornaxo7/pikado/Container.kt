package de.tornaxo7.pikado

import android.content.Context
import de.tornaxo7.pikado.data.VikunjaRepository

class Container(context: Context) {
    val vikunjaRepository by lazy {
        VikunjaRepository(context)
    }
}