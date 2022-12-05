package main.trackr.api


import main.trackr.models.TaskModel
import retrofit2.Call
import retrofit2.http.*

interface TaskApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )

    @POST("tasks/")
    fun createTask(@Body task: TaskModel): Call<TaskModel>

    @GET("tasks/")
    fun getAll(): Call<List<TaskModel>>

    @GET("tasks/")
    fun getTasksFromProject(@Query("project") id: Int): Call<List<TaskModel>>
}
