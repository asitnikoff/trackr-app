package main.trackr.views.interfaces

import main.trackr.models.ProjectModel

interface ProjectView {
    fun getProject(): ProjectModel
    fun getProjectName(): String
    fun getProjectSlug(): String
    fun getProjectDescription(): String
    fun showMessage(message: String)
}