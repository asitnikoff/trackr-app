package com.example.trackr_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val projects: Button = findViewById(R.id.projects)
        val profile: Button = findViewById(R.id.profile)

        projects.setOnClickListener {
            intent = Intent(this, Projects::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            intent = Intent(this, Profile::class.java)
            startActivity(intent)
        }
    }
}