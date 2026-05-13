package com.bohdan.githubuserviewer.data.model

import com.squareup.moshi.Json

data class Repository(
    val id: Long,
    val name: String,
    val description: String?,
    @Json(name = "html_url") val htmlUrl: String,
    @Json(name = "stargazers_count") val stars: Int,
    val language: String?,
    val fork: Boolean
)