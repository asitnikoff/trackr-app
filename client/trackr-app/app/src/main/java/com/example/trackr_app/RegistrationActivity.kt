package com.example.trackr_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.trackr_app.GlobalData.Companion.users

class RegistrationActivity : AppCompatActivity() {
    private lateinit var btnRegistration: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegistration = findViewById(R.id.btn_register)

        btnRegistration.setOnClickListener {
            val login: String? = findViewById<EditText>(R.id.edt_login)
                                 .text
                                 ?.toString()
            val password: String? = findViewById<EditText>(R.id.edt_password)
                                    .text
                                    ?.toString()
            val passwordConfirmation: String? = findViewById<EditText>(
                                                    R.id.edt_confirmation_password
                                                )
                                                .text
                                                ?.toString()

            when {
                (password == passwordConfirmation) &&
                (login != null) &&
                (password != null) -> {
                    addNewUser(login, password)
                    this.finish()
                }
            }
        }
    }

    private fun addNewUser(login: String, password: String) {
        users.add(User(login, password, users.size + 1))
    }
}