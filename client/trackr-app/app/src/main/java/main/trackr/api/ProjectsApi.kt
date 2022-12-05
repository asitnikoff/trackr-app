package main.trackr.api

import main.trackr.models.ProjectModel
import main.trackr.models.UserModel
import retrofit2.Call
import retrofit2.http.*

interface ProjectsApi {
    @Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )

    @POST("projects/")
    fun createProject(@Body user: ProjectModel): Call<ProjectModel>

    @GET("projects/")
    fun getAll(): Call<List<ProjectModel>>
}
