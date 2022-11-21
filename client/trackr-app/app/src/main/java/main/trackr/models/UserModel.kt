package main.trackr.models

import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import main.trackr.api.UsersApi
import main.trackr.api.api
import main.trackr.models.requests.UserRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


//val UNKNOWN_STRING: String = ""


class UserModel(var login: String, var password: String) {
    var user_id: Int = 0
    var name: String = ""
    var surname: String = ""
    var patronymic: String = ""
    //    var projects: MutableList<ProjectModel> = mutableListOf()
    var email: String = ""
    var phone_number: String = ""
    var telegram_id: String = ""
    var vk_id: String = ""
    //    var roles: MutableList<RoleModel> = mutableListOf()
    var is_deleted: Boolean = false

    private val req: UserRequest = UserRequest()


    suspend fun addUser() {
        req.addUser(this)
    }
}