package de.tornaxo7.pikado

import android.app.Application


class PikadoApplication: Application() {

    lateinit var container: Container

    override fun onCreate() {
        super.onCreate()

        container = Container(this)
    }
}