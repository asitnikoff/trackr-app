package main.trackr.models

import com.google.gson.annotations.SerializedName

class RoleModel {
    @SerializedName("role_id")
    val roleId: Int = -1

    @SerializedName("title")
    var title: String = ""
}