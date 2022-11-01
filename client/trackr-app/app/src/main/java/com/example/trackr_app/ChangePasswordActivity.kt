package com.example.trackr_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.trackr_app.GlobalData.Companion.user
import com.example.trackr_app.GlobalData.Companion.users

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        button = findViewById(R.id.btn_confirm)

        button.setOnClickListener {
            val password: String? = findViewById<EditText>(R.id.edt_password).text?.toString()
            val passwordConfirm: String? = findViewById<EditText>(R.id.edt_confirmation_password)
                                            .text
                                            ?.toString()

            if ((password == passwordConfirm) && (password != null)) {
                user.password = password
                users[user.positionInTotal].password = password
                Toast.makeText(this, "Пароль был обновлен", Toast.LENGTH_SHORT)
                     .show()
                this.finish()
            }
        }
    }
}