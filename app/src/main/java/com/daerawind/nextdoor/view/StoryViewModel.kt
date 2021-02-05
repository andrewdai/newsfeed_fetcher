package com.daerawind.nextdoor.view

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daerawind.nextdoor.data.api.Result
import com.daerawind.nextdoor.data.api.story.StoryRepository
import com.daerawind.nextdoor.model.StoryList
import kotlinx.coroutines.launch

class StoryViewModel(private val storyRepository: StoryRepository) : ViewModel() {

    private var _storiesLiveData = MutableLiveData<StoryList>()
    val storiesLiveData: LiveData<StoryList> get() = _storiesLiveData

    private var _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> get() = _errorLiveData

    fun getStories(page: String) = viewModelScope.launch {
        when (val result = storyRepository.getStories(page)) {
            is Result.Success -> {
                Log.d("StoryViewModel", "Got data")
                _storiesLiveData.postValue(result.data)
            }
            is Result.Failure -> {
                Log.d("StoryViewModel", "Got error")
                _errorLiveData.postValue("Error: ${result.code}, ${result.msg}")
            }
        }
    }
}