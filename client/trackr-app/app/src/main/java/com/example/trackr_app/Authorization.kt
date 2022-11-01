package com.example.trackr_app

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class Authorization : AppCompatActivity() {
    companion object {
        @JvmStatic val user = User()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        val logInButton: Button = findViewById(R.id.btn_log_in)

        logInButton.setOnClickListener {
            checkCredentialsData()
        }
    }

    private fun checkCredentialsData() {
        val login = findViewById<EditText>(R.id.edt_login).text.toString()
        val password = findViewById<EditText>(R.id.edt_password).text.toString()

        if ((user.login == login) && (user.password == password)) {
            changeActivities()
        } else {
            println("Incorrect data!")
        }
    }

    private fun changeActivities() {
        val intent = Intent(this, Home::class.java);
        startActivity(intent)
    }
}