package main.trackr.models

import android.widget.Toast
import com.google.gson.annotations.SerializedName
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
    @SerializedName("user_id")
    var userId: Int = 0

    @SerializedName("name")
    var name: String = ""

    @SerializedName("surname")
    var surname: String = ""

    @SerializedName("patronymic")
    var patronymic: String = ""

    @SerializedName("email")
    var email: String = ""

    @SerializedName("phone_number")
    var phoneNumber: String = ""

    @SerializedName("telegram_id")
    var telegramId: String = ""

    @SerializedName("vk_id")
    var vkId: String = ""

    @SerializedName("projects")
    var projects: MutableList<ProjectModel> = mutableListOf()

    @SerializedName("roles")
    var roles: MutableList<RoleModel> = mutableListOf()

    @SerializedName("is_deleted")
    var isDeleted: Boolean = false

    @Transient
    private val req: UserRequest = UserRequest()

    fun addUser() {
        req.addUser(this)
    }
}