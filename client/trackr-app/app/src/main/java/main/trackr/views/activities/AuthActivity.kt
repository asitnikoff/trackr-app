package main.trackr.views.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import main.trackr.R
import main.trackr.controllers.AuthController
import main.trackr.models.TaskModel
import main.trackr.models.UserModel
import main.trackr.views.interfaces.AuthView

class AuthActivity : AppCompatActivity(), AuthView {
    private val btnRegistration: Button by lazy { findViewById(R.id.btnRegister) }
    private val logInButton: Button by lazy { findViewById(R.id.btnLogIn) }
    private val controller: AuthController = AuthController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)
        controller.bind(this)

        logInButton.setOnClickListener {
            println("waiting...")
            controller.authorize()
        }

        btnRegistration.setOnClickListener {
            changeActivity(RegistrationActivity::class.java)
        }
    }

    private fun changeActivity(newActivity: Class<*>) {
        val intent = Intent(this, newActivity)
        startActivity(intent)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun successfullyAuthorized(user: UserModel) {
        showMessage("Пользователь успешно авторизован!")
        controller.saveUserToPreferences(
            this.getSharedPreferences("global", Context.MODE_PRIVATE),
            user
        )
        changeActivity(HomeActivity::class.java)
    }

    override fun unsuccessfullyAuthorized() {
        showMessage("Неверно введены логин и/или пароль")
    }

    override fun getLogin() = findViewById<EditText>(R.id.edtLogin).text.toString()

    override fun getPassword() = findViewById<EditText>(R.id.edtPassword).text.toString()
}