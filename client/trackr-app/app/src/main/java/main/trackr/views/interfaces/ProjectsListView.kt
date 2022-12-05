package main.trackr.views.interfaces

import main.trackr.models.ProjectModel

interface ProjectsListView {
    fun showMessage(message: String)
    fun notifyProjectsListChanged(result: List<ProjectModel>)
}