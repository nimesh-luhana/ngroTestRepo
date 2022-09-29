package com.ngro.ui.newsList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ngro.data.model.NewsList
import com.ngro.ui.newsList.NewsListFragmentViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
internal class NewsListFragmentViewModelTest : NewsListBaseTest() {
    private lateinit var newsListFragmentViewModel: NewsListFragmentViewModel

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    override fun setUp() {
        super.setUp()
        newsListFragmentViewModel = NewsListFragmentViewModel(newsListRepository)
    }

    @Test
    fun `observe livedata for list of newsDetails successfully`() {
        newsListFragmentViewModel.getNewsList()
        newsListFragmentViewModel.newsListLD.observeForever(object :
            Observer<NewsList> {
            override fun onChanged(t: NewsList?) {
                assertEquals(t!!.results[0], expectedSuccessValue)
            }
        })

    }
}