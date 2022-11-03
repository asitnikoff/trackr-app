package com.example.trackr_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ProjectsListActivity : AppCompatActivity() {
    companion object {
        @JvmStatic lateinit var adapter: ArrayAdapter<String>
        @JvmStatic val projectsList = mutableListOf(
            "VK", "Instagram", "Facebook", "Trackr App"
        )
    }

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

        listView = findViewById(R.id.projectsList)
        adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            projectsList
        )
        listView.adapter = adapter

        listView.setOnItemClickListener { _, view: View?, _, _ ->
            val intent = Intent(this, ProjectActivity::class.java)
            val textView: TextView = view as TextView
            intent.putExtra("projectName", textView.text)
            startActivity(intent)
        }
    }
}