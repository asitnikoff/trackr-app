package com.example.trackr_app

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class Projects : AppCompatActivity() {
    companion object {
        @JvmStatic lateinit var adapter: ArrayAdapter<String>
        @JvmStatic val projectsList = mutableListOf(
            "VK", "Instagram", "Facebook", "Trackr App"
        )
    }

    private lateinit var listView: ListView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        listView = findViewById(R.id.listView)
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            projectsList
        )
        listView.adapter = adapter
        button = findViewById(R.id.btnAddNewTask)

        button.setOnClickListener {
            intent = Intent(this, AddTask::class.java)
            startActivity(intent)
        }
    }
}