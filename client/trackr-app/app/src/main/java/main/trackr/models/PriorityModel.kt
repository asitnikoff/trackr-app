package main.trackr.models

import com.google.gson.annotations.SerializedName
import main.trackr.models.requests.ProjectRequest
import main.trackr.models.requests.UserRequest

class PriorityModel {
    @SerializedName("priority_id")
    var priorityId: Int = -1

    @SerializedName("title")
    var title: String = ""
}