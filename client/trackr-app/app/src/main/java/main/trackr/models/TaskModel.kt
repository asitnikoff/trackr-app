package main.trackr.models

import com.google.gson.annotations.SerializedName
import java.util.Date

class TaskModel {
    @SerializedName("task_id")
    var taskId: Int = -1

    @SerializedName("task_title")
    var taskTitle: String = ""

    @SerializedName("task_slug")
    var taskSlug: String = ""

    var tags: MutableList<TagModel> = mutableListOf()
    var description: String = ""

    @SerializedName("create_date")
    var createDate: Date = Date()

    @SerializedName("end_date")
    var endDate: Date = Date()

    @SerializedName("start_date")
    var startDate: Date = Date()

    @SerializedName("close_date")
    var closeDate: Date = Date()

    var performer: UserModel = UserModel("", "")
    var author: UserModel = UserModel("", "")
    lateinit var priority: PriorityModel

    @SerializedName("is_open")
    var isOpen: Boolean = true

    lateinit var project: ProjectModel
}