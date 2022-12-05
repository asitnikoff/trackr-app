package main.trackr.views.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import main.trackr.R
import main.trackr.controllers.AddProjectController
import main.trackr.models.ProjectModel
import main.trackr.views.interfaces.ProjectView

class AddProjectActivity : AppCompatActivity(), ProjectView {
    private lateinit var button: Button
    private val gson = Gson()
    private val controller: AddProjectController = AddProjectController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_new_project)

        controller.bind(this)

        button = findViewById(R.id.btnAddProject)

        button.setOnClickListener {
            val project: ProjectModel = getProject()
            controller.addProjectToDatabase(project) {
                showMessage("Вроде проект добавился в бд. Я хз, если честно :))")
                this.finish()
            }
        }
    }

    override fun getProjectName(): String = findViewById<EditText>(R.id.edtProjectName).text.toString()

    override fun getProjectSlug(): String = findViewById<EditText>(R.id.edtProjectSlug).text.toString()

    override fun getProjectDescription(): String = findViewById<EditText>(R.id.edtProjectDescription).text.toString()

    override fun getProject(): ProjectModel {
        val project: ProjectModel = ProjectModel()
        project.projectName = getProjectName()
        project.projectSlug = getProjectSlug()
        project.description = getProjectDescription()
        return project
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}