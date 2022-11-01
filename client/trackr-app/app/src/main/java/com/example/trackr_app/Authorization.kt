package com.example.trackr_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.trackr_app.GlobalData.Companion.user
import com.example.trackr_app.GlobalData.Companion.users

class Authorization : AppCompatActivity() {
    private lateinit var btnRegistration: Button
    private lateinit var logInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

        logInButton = findViewById(R.id.btn_log_in)
        btnRegistration = findViewById(R.id.btn_register)

        logInButton.setOnClickListener {
            checkCredentialsData()
        }

        btnRegistration.setOnClickListener {
            val intent = Intent(this, Registration::class.java)
            startActivity(intent)
        }
    }

    private fun checkCredentialsData() {
        val login = findViewById<EditText>(R.id.edt_login).text.toString()
        val password = findViewById<EditText>(R.id.edt_password).text.toString()

        val currentUser: User? = getUserByCreditionals(login, password)
        if (currentUser != null) {
            user = currentUser
            changeActivities()
        } else {
            println("Incorrect data!")
        }
    }

    private fun changeActivities() {
        val intent = Intent(this, Home::class.java);
        startActivity(intent)
    }

    private fun getUserByCreditionals(login: String, password: String): User? {
        for (currentUser in users) {
            if ((currentUser.login == login) &&
                (currentUser.password == password)) {
                return currentUser
            }
        }
        return null
    }
}