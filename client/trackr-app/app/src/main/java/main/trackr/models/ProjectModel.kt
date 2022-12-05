package main.trackr.models

import com.google.gson.annotations.SerializedName
import main.trackr.models.requests.ProjectRequest

class ProjectModel {
    @SerializedName("project_id")
    val projectId: Int = -1

    @SerializedName("project_slug")
    var projectSlug: String = ""

    @SerializedName("project_name")
    var projectName: String = ""

    @SerializedName("description")
    var description: String = ""
}