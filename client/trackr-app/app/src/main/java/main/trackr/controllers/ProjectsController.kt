package main.trackr.controllers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import main.trackr.models.ProjectModel
import main.trackr.models.requests.ProjectRequest
import main.trackr.views.interfaces.ProjectsListView

class ProjectsController {
    private lateinit var view: ProjectsListView
    private val projectRequest: ProjectRequest = ProjectRequest()

    fun bind(view: ProjectsListView) {
        this.view = view
    }

    fun setProjectsList() {
        CoroutineScope(Dispatchers.IO).launch {
            projectRequest.getAll { result ->
                view.notifyProjectsListChanged(result)
            }
        }
    }
}