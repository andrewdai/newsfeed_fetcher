package com.daerawind.nextdoor.data.api.story

// may also have a localData
class StoryRepository(private val storyRemoteData: StoryRemoteData) {

    suspend fun getStories(page: String) = storyRemoteData.getStories(page)
}