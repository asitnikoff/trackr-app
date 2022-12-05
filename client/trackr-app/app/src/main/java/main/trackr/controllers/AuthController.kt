package main.trackr.controllers

import android.content.Context
import android.content.SharedPreferences
import android.provider.Settings.Global.getString
import com.google.gson.Gson
import kotlinx.coroutines.*
import main.trackr.R
import main.trackr.models.UserModel
import main.trackr.models.requests.UserRequest
import main.trackr.views.interfaces.AuthView

class AuthController {
    private val userRequest: UserRequest = UserRequest()
    private lateinit var view: AuthView
    private val gson = Gson()

    fun bind(view: AuthView) {
        this.view = view
    }

    fun authorize() {
        val login = view.getLogin()
        CoroutineScope(Dispatchers.IO).launch {
            userRequest.getUser(login) { model ->
                MainScope().launch {
                    if (checkCredentialsData(model)) {
                        view.successfullyAuthorized(model!!)
                    } else {
                        view.unsuccessfullyAuthorized()
                    }
                }
            }
        }
    }

    private fun checkCredentialsData(user: UserModel?): Boolean {
        val password = view.getPassword()
        return (user != null) && (user.password == password)
    }

    fun saveUserToPreferences(pref: SharedPreferences, user: UserModel) {
        pref.edit().putString("authUser", gson.toJson(user, UserModel::class.java)).apply()
    }
}