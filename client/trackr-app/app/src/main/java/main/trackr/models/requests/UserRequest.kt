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
    }

    fun getUser(login: String, callback: (user: UserModel?) -> Unit = {}) {
        val call: Call<UserModel> = userApi.getUser(login)
        callback.invoke(call.execute().body())
    }

    fun updateUser(user: UserModel, handler: () -> Unit) {
        val call: Call<UserModel> = userApi.updateUser(user.userId, user)
        call.enqueue(object : Callback<UserModel> {
            override fun onResponse(call: Call<UserModel>, response: Response<UserModel>) {
                handler()
            }

            override fun onFailure(call: Call<UserModel>, t: Throwable) {
                println("[dbg] some error")
            }
        })
    }
}