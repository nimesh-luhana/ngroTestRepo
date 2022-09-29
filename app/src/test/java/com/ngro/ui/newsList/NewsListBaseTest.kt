package com.ngro.ui.newsList

import com.ngro.data.model.Media
import com.ngro.data.model.MediaMetaData
import com.ngro.data.remote.RestInterface
import com.ngro.data.model.NewsDetails
import com.ngro.data.model.NewsList
import com.ngro.ui.newsList.NewsListRepository
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


internal open class NewsListBaseTest {
    protected lateinit var mockWebServer: MockWebServer
    protected lateinit var newsListRepository: NewsListRepository
    protected lateinit var expectedSuccessValue: NewsList

    @Before
    open fun setUp() {
        expectedSuccessValue = NewsList(
            listOf(
                NewsDetails(
                    "At Ivana Trump’s Funeral, a Gold-Hued Coffin and the Secret Service",
                    "People adored Ivana.",
                    listOf(
                        Media(
                            listOf(
                                MediaMetaData("https://static01.nyt.com/images/2022/07/20/fashion/20IVANA-FUNERAL1/20IVANA-FUNERAL1-thumbStandard.jpg"),
                                MediaMetaData(
                                    "https://static01.nyt.com/images/2022/07/20/fashion/20IVANA-FUNERAL1/merlin_210358971_77cf7512-85a6-43df-8a98-a1481ba77376-mediumThreeByTwo210.jpg"
                                ),
                                MediaMetaData("https://static01.nyt.com/images/2022/07/20/fashion/20IVANA-FUNERAL1/merlin_210358971_77cf7512-85a6-43df-8a98-a1481ba77376-mediumThreeByTwo440.jpg")
                            )
                        )
                    )
                )
            )
        )
        mockWebServer = MockWebServer()
        val client = OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.SECONDS)
            .readTimeout(1, TimeUnit.SECONDS)
            .writeTimeout(1, TimeUnit.SECONDS)
            .build()

        val api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RestInterface::class.java)


        newsListRepository = NewsListRepository(api, "")
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }


}


