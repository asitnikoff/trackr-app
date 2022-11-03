package com.example.trackr_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ListView

class ProjectActivity : AppCompatActivity() {
    companion object {
        @JvmStatic lateinit var adapter: TasksAdapter
        @JvmStatic lateinit var tasks: MutableList<Task>
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

    private fun getTasksForCurrentProject(): MutableList<Task> {
        val tasks = mutableListOf<Task>()

        val projectName: String = intent.extras?.get("projectName").toString()

        for (task in GlobalData.tasks) {
            if (task.inProject.equals(projectName)) {
                tasks.add(task)
            }
        }

        return tasks
    }
}