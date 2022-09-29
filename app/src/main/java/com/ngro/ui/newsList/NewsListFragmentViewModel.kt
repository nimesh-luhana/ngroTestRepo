package com.ngro.ui.newsList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngro.data.model.NewsList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListFragmentViewModel @Inject constructor(private val repository: NewsListRepository) :
    ViewModel() {

    private val _newsListMLD = MutableLiveData<NewsList>()
    val newsListLD: LiveData<NewsList> = _newsListMLD

    fun getNewsList() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getNewsList()
            _newsListMLD.postValue(response)
        }
    }

}