package main.trackr.views.interfaces

import main.trackr.models.TaskModel

interface AddTaskView {
    fun getTask(): TaskModel
    fun getTaskName(): String
    fun getTaskSlug(): String
    fun getTaskDescription(): String
    fun showMessage(message: String)
}