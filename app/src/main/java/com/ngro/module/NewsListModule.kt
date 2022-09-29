package com.ngro.module

import com.ngro.BuildConfig
import com.ngro.ui.newsList.NewsListRepository
import com.ngro.data.remote.NetworkApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
class NewsListModule {
    @Provides
    fun provideRestInterface() = NetworkApi.getRestClient()

    @Provides
    fun provideRepository() = NewsListRepository(
        provideRestInterface(),
        BuildConfig.NYTIMES_API_KEY
    )
}