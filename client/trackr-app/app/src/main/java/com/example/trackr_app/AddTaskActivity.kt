package com.example.trackr_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddTaskActivity : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        button = findViewById(R.id.btnAddTask)

        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.edtText)
            GlobalData.tasks.add(
                Task(
                    editText.text.toString(),
                    GlobalData.user,
                    intent.extras?.get("projectName").toString()
                )
            )
            ProjectActivity.tasks.add(GlobalData.tasks.last())
            ProjectActivity.adapter.notifyDataSetChanged()
            this.finish()
        }
    }
}