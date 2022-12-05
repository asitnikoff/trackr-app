package main.trackr.controllers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import main.trackr.models.requests.TaskRequest
import main.trackr.views.interfaces.ProjectDetailView

class ProjectController {
    private lateinit var view: ProjectDetailView
    private val taskRequest: TaskRequest = TaskRequest()

    fun bind(view: ProjectDetailView) {
        this.view = view
    }

    fun setTasksListFromProject(projectId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            taskRequest.getTasksFromProject(projectId) { data ->
                view.notifyTasksListChanged(data)
            }
        }
    }
}