package com.daerawind.nextdoor.data.api

import com.daerawind.nextdoor.model.StoryList
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val baseUrl = "https://andrewmunn.github.io/newsfeed/"
    }


    @GET("page{id}.json")
    suspend fun getStories(@Path("id") id: String): Response<StoryList>
}