package br.com.db1.blockchain.repositories.network

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConfiguration() {
    private val retrofit: Retrofit

    init {
        val okHttpClient = okHttpClientInstance
        retrofit = getRetrofit(okHttpClient, "https://api.blockchain.info/")
    }

    private fun getRetrofit(okHttpClient: OkHttpClient, baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .serializeNulls()
                        .setLenient()
                        .excludeFieldsWithoutExposeAnnotation()
                        .create()
                )
            )
            .client(okHttpClient)
            .build()
    }

    companion object {
        private const val timeOut = 60L
        private val okHttpClientInstance: OkHttpClient = OkHttpClient()
            .newBuilder()
            .connectTimeout(timeOut, TimeUnit.SECONDS)
            .readTimeout(timeOut, TimeUnit.SECONDS)
            .writeTimeout(timeOut, TimeUnit.SECONDS)
            .addInterceptor(
                HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .build()
    }
}