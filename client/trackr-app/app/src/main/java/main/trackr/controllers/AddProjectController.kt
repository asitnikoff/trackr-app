package main.trackr.controllers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import main.trackr.models.ProjectModel
import main.trackr.models.requests.ProjectRequest
import main.trackr.views.interfaces.ProjectView

class AddProjectController {
    private val projectRequest: ProjectRequest = ProjectRequest()
    private lateinit var view: ProjectView

    fun bind(view: ProjectView) {
        this.view = view
    }

    fun addProjectToDatabase(project: ProjectModel, handler: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            projectRequest.addProject(project) {
                handler()
            }
        }
    }
}