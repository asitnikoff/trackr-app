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

    @SerializedName("tags")
    var tags: MutableList<TagModel> = mutableListOf()

    @SerializedName("description")
    var description: String = ""

    @SerializedName("create_date")
    var createDate: Date = Date()

    @SerializedName("end_date")
    var endDate: Date = Date()

    @SerializedName("start_date")
    var startDate: Date = Date()

    @SerializedName("close_date")
    var closeDate: Date = Date()

    @SerializedName("performer")
    var performer: UserModel = UserModel("", "")

    @SerializedName("author")
    var author: UserModel = UserModel("", "")

    @SerializedName("priority")
    var priority: PriorityModel = PriorityModel()

    @SerializedName("is_open")
    var isOpen: Boolean = true

    @SerializedName("project")
    var project: ProjectModel = ProjectModel()
}