package main.trackr.models.requests

import main.trackr.api.ProjectsApi
import main.trackr.api.api
import main.trackr.models.ProjectModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProjectRequest {
    private val projectApi: ProjectsApi = api.create(ProjectsApi::class.java)

    fun addProject(project: ProjectModel, handler: () -> Unit) {
        val call: Call<ProjectModel> = projectApi.createProject(project)
        call.enqueue(object : Callback<ProjectModel> {
            override fun onResponse(call: Call<ProjectModel>, response: Response<ProjectModel>) {
                handler()
            }

            override fun onFailure(call: Call<ProjectModel>, t: Throwable) {
                println("[dbg] some error")
            }
        })
    }

    fun getAll(handler: (data: List<ProjectModel>) -> Unit) {
        val call: Call<List<ProjectModel>> = projectApi.getAll()
        call.enqueue(object : Callback<List<ProjectModel>> {
            override fun onResponse(call: Call<List<ProjectModel>>, response: Response<List<ProjectModel>>) {
                handler(response.body()!!)
            }

            override fun onFailure(call: Call<List<ProjectModel>>, t: Throwable) {
                println("[dbg] some error")
            }
        })
    }
}