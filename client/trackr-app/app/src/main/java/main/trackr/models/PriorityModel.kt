package main.trackr.models

import com.google.gson.annotations.SerializedName

class PriorityModel {
    @SerializedName("priority_id")
    var priorityId: Int = -1

    var title: String = ""
}