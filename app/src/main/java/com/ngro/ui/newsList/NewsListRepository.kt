package com.ngro.ui.newsList;

import com.ngro.data.remote.RestInterface
import javax.inject.Inject

class NewsListRepository @Inject constructor(
    val restInterface: RestInterface,
    val apiKey: String
) {
    suspend fun getNewsList() =
        restInterface.getNewsList(apiKey)

}
