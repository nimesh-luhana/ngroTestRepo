package com.ngro

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import java.nio.charset.StandardCharsets

fun MockWebServer.enqueueResponse(fileName: String, responseCode: Int) {
        val inputStream = javaClass.classLoader?.getResourceAsStream("$fileName")

        val source = inputStream?.let { inputStream.source().buffer() }
        source?.let {
            enqueue(
                MockResponse()
                    .setResponseCode(responseCode)
                    .setBody(source.readString(StandardCharsets.UTF_8))
            )
        }
    }
