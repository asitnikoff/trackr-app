package main.trackr.views.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import main.trackr.R
import main.trackr.controllers.AddTaskController
import main.trackr.models.ProjectModel
import main.trackr.models.TaskModel
import main.trackr.models.UserModel
import main.trackr.views.interfaces.AddTaskView

class AddTaskActivity : AppCompatActivity(), AddTaskView {
    private lateinit var button: Button
    private val controller = AddTaskController()
    private lateinit var currentProject: ProjectModel
    private lateinit var globalPref: SharedPreferences
    private lateinit var authUser: UserModel
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        controller.bind(this)

        globalPref = this.getSharedPreferences("global", Context.MODE_PRIVATE)
        authUser = gson.fromJson(
            globalPref.getString("authUser", "{}"),
            UserModel::class.java
        )

        currentProject = gson.fromJson(
            intent.extras!!.get("project").toString(),
            ProjectModel::class.java
        )

        println("[dbg] projectId = ${currentProject.projectId}")

        button = findViewById(R.id.btnAddTask)

        button.setOnClickListener {
            val task: TaskModel = getTask()
            controller.addTaskToDatabase(task) {
                showMessage("Вроде задача добавилась в бд. Я хз, если честно :))")
                this.finish()
            }
        }
    }

    override fun getTaskName(): String = findViewById<EditText>(R.id.edtTaskName).text.toString()

    override fun getTaskSlug(): String = findViewById<EditText>(R.id.edtTaskSlug).text.toString()

    override fun getTaskDescription(): String = findViewById<EditText>(R.id.edtTaskDescription).text.toString()

    override fun getTask(): TaskModel {
        val task: TaskModel = TaskModel()
        task.taskTitle = getTaskName()
        task.taskSlug = getTaskSlug()
        task.description = getTaskDescription()
        task.project = currentProject
        task.author = authUser
        return task
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}