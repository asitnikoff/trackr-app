package main.trackr.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import main.trackr.R
//import main.trackr.models.GlobalDataModel.Companion.user
//import main.trackr.models.GlobalDataModel.Companion.users

class ChangePasswordActivity : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        button = findViewById(R.id.btnConfirm)

        button.setOnClickListener {
            val password: String? = findViewById<EditText>(R.id.edtPassword).text?.toString()
            val passwordConfirm: String? = findViewById<EditText>(R.id.edtConfirmationPassword)
                                            .text
                                            ?.toString()

            if ((password == passwordConfirm) && (password != null)) {
//                user.password = password
//                users[user.positionInTotal].password = password
                Toast.makeText(this, "Пароль был обновлен", Toast.LENGTH_SHORT)
                     .show()
                this.finish()
            }
        }
    }
}