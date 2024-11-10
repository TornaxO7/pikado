package de.tornaxo7.pikado.ui.main

enum class PikadoScreen {
    Home,
    Projects,
    Settings
}

data class PikadoUiState(
    val selectedScreen: PikadoScreen = PikadoScreen.Home
)
