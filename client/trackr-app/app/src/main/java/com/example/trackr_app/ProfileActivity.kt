package com.example.trackr_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.trackr_app.GlobalData.Companion.user

class ProfileActivity : AppCompatActivity() {
    private lateinit var btnChangePassword: Button
    private lateinit var btnExit: Button
    private lateinit var tvUsername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnChangePassword = findViewById(R.id.btn_change_password)
        btnExit = findViewById(R.id.btn_exit)

        btnChangePassword.setOnClickListener {
            intent = Intent(this, ChangePasswordActivity::class.java);
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            intent = Intent(this, AuthorizationActivity::class.java)
            startActivity(intent)
        }

        tvUsername = findViewById(R.id.tv_username)
        tvUsername.text = user.login
    }
}