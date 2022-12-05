package main.trackr.views.activities

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import main.trackr.R
import main.trackr.controllers.ChangePasswordController
import main.trackr.models.UserModel
import main.trackr.views.interfaces.ChangePasswordView

class ChangePasswordActivity : AppCompatActivity(), ChangePasswordView {
    private lateinit var button: Button
    private val controller = ChangePasswordController()
    private lateinit var globalPref: SharedPreferences
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        controller.bind(this)

        globalPref = this.getSharedPreferences("global", Context.MODE_PRIVATE)

        button = findViewById(R.id.btnConfirm)

        button.setOnClickListener {
            val user: UserModel = gson.fromJson(
                globalPref.getString("authUser", "{}"),
                UserModel::class.java
            )
            controller.updateUserPassword(user) {
                updateGlobalPref("authUser", user)
                Toast.makeText(this, "Пароль был обновлен", Toast.LENGTH_SHORT)
                    .show()
                this.finish()
            }
        }
    }

    private fun updateGlobalPref(arg: String, user: UserModel) {
        with (globalPref.edit()) {
            putString(arg, gson.toJson(user))
            apply()
        }
    }

    override fun getPassword(): String? = findViewById<EditText>(R.id.edtPassword).text?.toString()

    override fun getConfirmPassword(): String? = findViewById<EditText>(R.id.edtConfirmationPassword).text?.toString()
}