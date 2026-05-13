package com.bohdan.githubuserviewer.data.model

import com.squareup.moshi.Json

data class GitHubUser(
    val login: String,
    val name: String?,
    val bio: String?,
    @Json(name = "avatar_url") val avatarUrl: String,
    val followers: Int,
    val following: Int,
    @Json(name = "public_repos") val publicRepos: Int,
    val location: String?,
    val company: String?
)