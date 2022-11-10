package main.trackr.api

import main.trackr.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UsersApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )
    @POST("users/")
    fun createUser(@Body user: UserModel): Call<UserModel>
}