package main.trackr.models

import android.widget.Toast
import main.trackr.api.UsersApi
import main.trackr.api.api
import main.trackr.models.requests.UserRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


val UNKNOWN_STRING: String = ""


class UserModel(var login: String, var password: String) {
    var user_id: Int = 0
    var name: String = UNKNOWN_STRING
    var surname: String = UNKNOWN_STRING
    var patronymic: String  = UNKNOWN_STRING
//    var projects: MutableList<ProjectModel> = mutableListOf()
    var email: String = UNKNOWN_STRING
    var phone_number: String = UNKNOWN_STRING
    var telegram_id: String = UNKNOWN_STRING
    var vk_id: String = UNKNOWN_STRING
//    var roles: MutableList<RoleModel> = mutableListOf()
    var is_deleted: Boolean = false

    private val req: UserRequest = UserRequest()


    fun addUser() {
        req.addUser(this)
    }
}