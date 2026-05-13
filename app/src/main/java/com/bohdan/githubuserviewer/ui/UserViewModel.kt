package com.bohdan.githubuserviewer.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bohdan.githubuserviewer.data.api.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class UserViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Idle)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    fun searchUser(username: String) {
        if (username.isBlank()) return

        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val user = RetrofitInstance.api.getUser(username.trim())
                val repos = RetrofitInstance.api.getUserRepos(username.trim())
                _uiState.value = UiState.Success(user, repos)
            } catch (e: HttpException) {
                _uiState.value = when (e.code()) {
                    404 -> UiState.Error("User '$username' not found")
                    403 -> UiState.Error("Rate limit exceeded. Try again later.")
                    else -> UiState.Error("Server error: ${e.code()}")
                }
            } catch (e: IOException) {
                _uiState.value = UiState.Error("No internet connection")
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Unexpected error: ${e.message}")
            }
        }
    }

    fun reset() {
        _uiState.value = UiState.Idle
    }
}