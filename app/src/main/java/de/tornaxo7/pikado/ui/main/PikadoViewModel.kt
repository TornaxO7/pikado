package de.tornaxo7.pikado.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import de.tornaxo7.pikado.PikadoApplication
import de.tornaxo7.pikado.data.VikunjaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class PikadoViewModel(
    private val vikunjaRepository: VikunjaRepository
) : ViewModel() {
    private var _uiState: MutableStateFlow<PikadoUiState> = MutableStateFlow(PikadoUiState())
    val uiState: StateFlow<PikadoUiState> = _uiState.asStateFlow()

    fun setScreen(screen: PikadoScreen) {
        _uiState.update { current ->
            current.copy(selectedScreen = screen)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as PikadoApplication)

                PikadoViewModel(application.container.vikunjaRepository)
            }
        }
    }
}