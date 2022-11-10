package main.trackr.models.requests

import main.trackr.api.UsersApi
import main.trackr.api.api
import main.trackr.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRequest {
    fun addUser(user: UserModel) {
        val userApi: UsersApi = api.create(UsersApi::class.java)
        val call: Call<UserModel> = userApi.createUser(user)
        call.enqueue(object: Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                println("Response: ${response}")
                val responseUser: UserModel? = response.body()
                if (responseUser == null) {
                    println("Ooops... Something bad!")
                } else {
                    println("Id: ${responseUser.user_id}")
                    println("Login: ${responseUser.login}")
                    println("Password: ${responseUser.password}")
                }
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                println(t.message)
            }
        })
    }
}