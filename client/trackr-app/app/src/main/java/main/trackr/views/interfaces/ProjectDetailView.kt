package main.trackr.views.interfaces

import main.trackr.models.TaskModel

interface ProjectDetailView {
    fun notifyTasksListChanged(data: List<TaskModel>?)
}