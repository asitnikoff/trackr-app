package main.trackr.models.requests

import main.trackr.api.TaskApi
import main.trackr.api.api
import main.trackr.models.TaskModel
import okhttp3.internal.concurrent.Task
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TaskRequest {
    private val taskApi: TaskApi = api.create(TaskApi::class.java)

    fun addTask(task: TaskModel, handler: () -> Unit) {
        val call: Call<TaskModel> = taskApi.createTask(task)
        call.enqueue(object : Callback<TaskModel> {
            override fun onResponse(call: Call<TaskModel>, response: Response<TaskModel>) {
                handler()
            }

            override fun onFailure(call: Call<TaskModel>, t: Throwable) {
                println("[dbg] some error")
            }
        })
    }

    fun getTasksFromProject(projectId: Int, handler: (data: List<TaskModel>?) -> Unit = {}) {
        val call: Call<List<TaskModel>> = taskApi.getTasksFromProject(projectId)
        call.enqueue(object : Callback<List<TaskModel>> {
            override fun onResponse(
                call: Call<List<TaskModel>>,
                response: Response<List<TaskModel>>
            ) {
                handler(response.body())
            }

            override fun onFailure(call: Call<List<TaskModel>>, t: Throwable) {
                println("[dbg] some error")
            }
        })

    }
}