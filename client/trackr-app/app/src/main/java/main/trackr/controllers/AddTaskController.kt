package main.trackr.controllers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import main.trackr.models.TaskModel
import main.trackr.models.UserModel
import main.trackr.models.requests.TaskRequest
import main.trackr.views.interfaces.AddTaskView

class AddTaskController {
    private lateinit var view: AddTaskView
    private val taskRequest: TaskRequest = TaskRequest()

    fun bind(view: AddTaskView) {
        this.view = view
    }

    fun addTaskToDatabase(task: TaskModel, handler: () -> Unit) {
        CoroutineScope(Dispatchers.IO).launch {
            taskRequest.addTask(task) {
                handler()
            }
        }
    }
}