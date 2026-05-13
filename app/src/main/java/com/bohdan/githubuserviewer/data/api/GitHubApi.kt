package com.bohdan.githubuserviewer.data.api

import com.bohdan.githubuserviewer.data.model.GitHubUser
import com.bohdan.githubuserviewer.data.model.Repository
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("users/{username}")
    suspend fun getUser(@Path("username") username: String): GitHubUser

    @GET("users/{username}/repos")
    suspend fun getUserRepos(
        @Path("username") username: String,
        @Query("sort") sort: String = "updated",
        @Query("per_page") perPage: Int = 30
    ): List<Repository>
}