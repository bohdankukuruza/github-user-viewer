package com.bohdan.githubuserviewer.ui

import com.bohdan.githubuserviewer.data.model.GitHubUser
import com.bohdan.githubuserviewer.data.model.Repository

sealed interface UiState {
    data object Idle : UiState
    data object Loading : UiState
    data class Success(
        val user: GitHubUser,
        val repos: List<Repository>
    ) : UiState
    data class Error(val message: String) : UiState
}