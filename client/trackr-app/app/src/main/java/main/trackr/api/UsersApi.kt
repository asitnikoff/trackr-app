package main.trackr.api

import main.trackr.models.UserModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface UsersApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )

    @POST("users/")
    fun createUser(@Body user: UserModel): Call<UserModel>

    @GET("users/find/")
    fun getUser(@Query("login") login: String): Call<UserModel>
}