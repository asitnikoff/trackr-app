package main.trackr.models.requests

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import main.trackr.api.UsersApi
import main.trackr.api.api
import main.trackr.models.UserModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response

class UserRequest {
    private val userApi: UsersApi = api.create(UsersApi::class.java)

    fun addUser(user: UserModel) {
        val call: Call<UserModel> = userApi.createUser(user)
        call.execute()
//        call.enqueue(object: Callback<UserModel> {
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                val responseUser: UserModel? = response.body()
//                if (responseUser == null) {
//                    println("Ooops... Something bad!")
//                } else {
//                    println("Id: ${responseUser.user_id}")
//                    println("Login: ${responseUser.login}")
//                    println("Password: ${responseUser.password}")
//                }
//            }
//
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                println(t.message)
//            }
//        })
    }

    fun getUser(login: String, callback: (user: UserModel?) -> Unit = {}) {
        val call: Call<UserModel> = userApi.getUser(login)
//        call.enqueue(object : Callback<UserModel> {
//            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
//                callback.invoke(response.body())
//            }
//
//            override fun onFailure(call: Call<UserModel>, t: Throwable) {
//                println("Something baaaaaaaaaad!!!")
//            }
//        })
        callback.invoke(call.execute().body())
    }

}