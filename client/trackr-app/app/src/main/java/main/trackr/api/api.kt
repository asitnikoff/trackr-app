package main.trackr.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

//const val BASE_URL = "http://10.0.2.2:8000/api/"    // for emulator
const val BASE_URL = "http://localhost:8000/api/"   // for real device


val clientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()
val loggingInterceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()


val api: Retrofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .client(
                                clientBuilder.addInterceptor(
                                    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
                                ).build()
                            )
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()