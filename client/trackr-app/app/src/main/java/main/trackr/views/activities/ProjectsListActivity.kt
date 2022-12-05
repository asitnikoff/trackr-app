package main.trackr.views.activities

import android.app.Activity
import main.trackr.R
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import main.trackr.adapters.ProjectsAdapter
import main.trackr.adapters.TasksAdapter
import main.trackr.controllers.ProjectsController
import main.trackr.models.ProjectModel
import main.trackr.views.interfaces.ProjectsListView

class ProjectsListActivity : AppCompatActivity(), ProjectsListView {
    private lateinit var adapter: ProjectsAdapter
    private var projectsList: MutableList<ProjectModel> = mutableListOf()
    private lateinit var listView: ListView
    private lateinit var btnAddProject: Button
    private val controller = ProjectsController()
    private val gson = Gson()
    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                val jsonProject = it.data!!.extras!!.get("jsonProject").toString()
                val project: ProjectModel = gson.fromJson(jsonProject, ProjectModel::class.java)
//                projectsList.add(project)
                adapter.notifyDataSetChanged()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        controller.bind(this)

//        controller.setProjectsList()
        listView = findViewById(R.id.projectsList)
        btnAddProject = findViewById(R.id.btnAddNewProject)

        adapter = ProjectsAdapter(
            this,
            android.R.layout.simple_list_item_1,
            projectsList
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position: Int, _ ->
            val intent = Intent(this, ProjectActivity::class.java)
            intent.putExtra("project",
                            gson.toJson(projectsList[position]))
            startActivity(intent)
        }

        btnAddProject.setOnClickListener {
            val intent = Intent(this, AddProjectActivity::class.java)
//            getResult.launch(intent)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        controller.setProjectsList()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun notifyProjectsListChanged(result: List<ProjectModel>) {
        projectsList.clear()
        projectsList.addAll(result)
        adapter.notifyDataSetChanged()
    }
}