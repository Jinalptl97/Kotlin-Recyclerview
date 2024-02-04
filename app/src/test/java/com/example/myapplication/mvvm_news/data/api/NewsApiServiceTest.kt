package com.example.myapplication.mvvm_news.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiServiceTest {
    private lateinit var service: NewsApiService
    private lateinit var server:MockWebServer

    @Before
    fun setUp() {
       server=MockWebServer()
        service=Retrofit.Builder().baseUrl(server.url(""))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    private fun enqueMockResponse(fileName: String){
        val inputstream=javaClass.classLoader!!.getResourceAsStream(fileName)
        val source=inputstream.source().buffer()
        val mockResponse=MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        server.enqueue(mockResponse)

    }
    @Test
    fun getTopHeadlines_sentRequest_receivedExpected(){
        runBlocking {
            enqueMockResponse("newsresponse.json")
        val responsebody=    service.getTopHeadlines("us",1).body()
            val request=server.takeRequest()
            assertThat(responsebody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=d260fed101a745b3a186165f6a3db1af")
        }

    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPagesize() {
        runBlocking {
            enqueMockResponse("newsresponse.json")
            val responsebody = service.getTopHeadlines("us", 1).body()
            val articlelist = responsebody!!.articles
            assertThat(articlelist.size).isEqualTo(20)

        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent() {
        runBlocking {
            enqueMockResponse("newsresponse.json")
            val responsebody = service.getTopHeadlines("us", 1).body()
            val articlelist = responsebody!!.articles
           val article=articlelist[0]
            assertThat(article.url).isEqualTo("https://www.ndtv.com/world-news/worlds-largest-cruise-ship-icon-of-the-seas-sets-sail-raising-methane-emission-concerns-4942189")
            assertThat(article.publishedAt).isEqualTo("2024-01-27T11:33:44Z")

        }
    }

    @After
    fun tearDown() {
        server.shutdown()
    }
}