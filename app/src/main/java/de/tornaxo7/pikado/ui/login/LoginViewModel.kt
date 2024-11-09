package de.tornaxo7.pikado.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel() {
    private var _uiState = MutableStateFlow(LoginUiState())
    val uiState = _uiState.asStateFlow()

    fun setUsername(username: String) {
        _uiState.update { current ->
            current.copy(username = username)
        }
    }

    fun setPassword(password: String) {
        _uiState.update { current ->
            current.copy(password = password)
        }
    }

    fun setServerUrl(serverUrl: String) {
        _uiState.update { current ->
            current.copy(serverUrl = serverUrl)
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                LoginViewModel()
            }
        }
    }
}