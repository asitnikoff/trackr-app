package main.trackr.views.activities

import main.trackr.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import main.trackr.models.GlobalDataModel
import main.trackr.models.TaskModel
import main.trackr.adapters.TasksAdapter

class ProjectActivity : AppCompatActivity() {
    companion object {
        @JvmStatic lateinit var adapter: TasksAdapter
        @JvmStatic lateinit var tasks: MutableList<TaskModel>
    }

    private lateinit var btnAddNewTask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_project)

        tasks = getTasksForCurrentProject()
        adapter = TasksAdapter(this, android.R.layout.simple_list_item_2, tasks)
        val tasksList: ListView = findViewById(R.id.tasksList)
        tasksList.adapter = adapter

        btnAddNewTask = findViewById(R.id.btnAddNewTask)

        btnAddNewTask.setOnClickListener {
            intent.setClass(this, AddTaskActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getTasksForCurrentProject(): MutableList<TaskModel> {
        val tasks = mutableListOf<TaskModel>()

        val projectName: String = intent.extras?.get("projectName").toString()

//        for (task in GlobalDataModel.tasks) {
//            if (task.inProject.equals(projectName)) {
//                tasks.add(task)
//            }
//        }

        return tasks
    }
}