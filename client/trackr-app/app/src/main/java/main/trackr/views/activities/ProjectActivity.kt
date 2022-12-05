package main.trackr.views.activities

import android.content.Intent
import main.trackr.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import com.google.gson.Gson
import main.trackr.models.TaskModel
import main.trackr.adapters.TasksAdapter
import main.trackr.controllers.ProjectController
import main.trackr.models.ProjectModel
import main.trackr.views.interfaces.ProjectDetailView

class ProjectActivity : AppCompatActivity(), ProjectDetailView {
    private lateinit var tasksList: ListView
    private val tasks: MutableList<TaskModel> = mutableListOf()
    private lateinit var adapter: TasksAdapter
    private lateinit var btnAddNewTask: Button
    private lateinit var currentProject: ProjectModel
    private val gson = Gson()
    private val controller = ProjectController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        currentProject = gson.fromJson(
            intent.extras!!.get("project").toString(),
            ProjectModel::class.java
        )

        tasksList = findViewById(R.id.tasksList)

        controller.bind(this)

//        controller.setTasksListFromProject(currentProject.projectId)
        adapter = TasksAdapter(this, android.R.layout.simple_list_item_2, tasks)
        tasksList.adapter = adapter

        btnAddNewTask = findViewById(R.id.btnAddNewTask)

        btnAddNewTask.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            intent.putExtra("project", this.intent.extras!!.get("project").toString())
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        controller.setTasksListFromProject(currentProject.projectId)
    }

    override fun notifyTasksListChanged(data: List<TaskModel>?) {
        tasks.clear()
        if (data != null) {
            tasks.addAll(data)
        }
        adapter.notifyDataSetChanged()
    }
}