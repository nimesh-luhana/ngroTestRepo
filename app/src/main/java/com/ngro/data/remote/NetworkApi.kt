package com.ngro.data.remote

import com.ngro.BuildConfig
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkApi {

    companion object {
        private val BASE_URL: String = BuildConfig.BASE_URL

        fun getRestClient(baseUrl:String = BASE_URL): RestInterface {
            val retrofit = buildRetrofit(baseUrl)
            return retrofit.create(RestInterface::class.java)
        }

        private fun buildRetrofit(baseUrl:String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }


        val gSONConfiguration: Gson?
            get() = try {
                GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).excludeFieldsWithModifiers()
                    .create()
            } catch (e: Exception) {
                null
            }
    }
}
