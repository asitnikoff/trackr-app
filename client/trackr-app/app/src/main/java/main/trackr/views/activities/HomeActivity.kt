package main.trackr.views.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import main.trackr.R

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val projects: Button = findViewById(R.id.projects)
        val profile: Button = findViewById(R.id.profile)

        projects.setOnClickListener {
            intent = Intent(this, ProjectsListActivity::class.java)
            startActivity(intent)
        }

        profile.setOnClickListener {
            intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}