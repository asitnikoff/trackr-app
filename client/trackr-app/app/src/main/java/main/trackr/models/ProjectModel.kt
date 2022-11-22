package main.trackr.models

import com.google.gson.annotations.SerializedName

class ProjectModel {
    @SerializedName("project_id")
    val projectId: Int = -1

    @SerializedName("project_slug")
    var projectSlug: String = ""

    @SerializedName("project_name")
    var projectName: String = ""

    var description: String = ""
}