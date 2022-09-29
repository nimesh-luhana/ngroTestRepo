package com.ngro.ui.newsList

import com.ngro.enqueueResponse
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test


internal class NewsListRepositoryTest : NewsListBaseTest() {

    @Test
    fun `successfully receive popular news list`() {
        mockWebServer.enqueueResponse("newsListSuccessResponse.json", 200)

        runBlocking {
            val received = newsListRepository.getNewsList()
            assertEquals(received, expectedSuccessValue)
        }
    }

}


