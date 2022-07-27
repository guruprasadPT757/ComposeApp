package com.app.composeapp.network

import com.app.composeapp.network.models.allvideos.AllVideoResponse
import com.app.composeapp.network.models.trayvideos.TrayVideoResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


const val BASE_URL = "https://psapi-env.voot.com/jiouat/voot/v1/voot-mobile/"
const val BASE_IMAGE_URL_270_152 = "https://v3img.voot.com/resizeLow,w_270,h_152/"
const val BASE_IMAGE_URL_14_3 = "https://v3img.voot.com/resizeMedium,w_1920,h_411/"
const val BASE_IMAGE_URL_16_9 = "https://v3img.voot.com/resizeMedium,w_1920,h_411/"
const val BASE_IMAGE_URL_4_3 ="https://v3img.voot.com/resizeMedium,w_480,h_360/"

interface APIService {

    @GET("view/my-voot?responseType=common")
    suspend fun getAllVideos(@Query("page") page: Int?): AllVideoResponse

    @GET
    suspend fun getTrayVideos(@Url url: String, @Query("page") page: Int?): TrayVideoResponse

    companion object {
        var apiService: APIService? = null
        fun getInstance(): APIService {

            if (apiService == null) {
                val interceptor = HttpLoggingInterceptor()
                interceptor.level = HttpLoggingInterceptor.Level.BODY
                val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()
                apiService = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!
        }
    }
}