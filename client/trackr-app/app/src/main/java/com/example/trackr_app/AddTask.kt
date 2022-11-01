package com.example.trackr_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class AddTask : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        button = findViewById(R.id.btnAddTask)

        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.edtText)
            Projects.projectsList.add(0, editText.text.toString())
            Projects.adapter.notifyDataSetChanged()
            this.finish()
        }
    }
}