package com.daerawind.nextdoor.data.api.story

import com.daerawind.nextdoor.data.api.ApiService
import com.daerawind.nextdoor.data.api.Result
import com.daerawind.nextdoor.model.StoryList

class StoryRemoteData(private val apiService: ApiService) {

    suspend fun getStories(page: String): Result<StoryList> {
        val response = apiService.getStories(page)
        return if (response.isSuccessful) {
            val body = response.body()
            if (body != null) {
                Result.Success(body)
            } else {
                Result.Failure(-1, "body is null")
            }
        } else {
            Result.Failure(0, "call failed")
        }
    }
}