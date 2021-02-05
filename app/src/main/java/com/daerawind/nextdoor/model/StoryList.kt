package com.daerawind.nextdoor.model

data class StoryList(
    val nextPageId: String? = null,
    val stories: List<Story> = mutableListOf()
)