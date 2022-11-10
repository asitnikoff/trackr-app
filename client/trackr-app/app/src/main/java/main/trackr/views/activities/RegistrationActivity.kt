package main.trackr.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import main.trackr.controllers.RegistrationController
//import main.trackr.models.GlobalDataModel.Companion.users
import main.trackr.models.UserModel
import main.trackr.R
import main.trackr.views.interfaces.RegistrationView

class RegistrationActivity : AppCompatActivity(), RegistrationView {
    private lateinit var btnRegistration: Button
    private val controller: RegistrationController = RegistrationController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnRegistration = findViewById(R.id.btnRegister)

        btnRegistration.setOnClickListener {
            if (controller.registrationSuccessful(this)) {
                showSuccessfulRegistrationMessage()
                this.finish()
            } else {
                showIncorrectDataMessage()
            }
        }
    }

    fun showSuccessfulRegistrationMessage() {
        showMessage("Аккаунт успешно зарегистрирован!")
    }

    fun showIncorrectDataMessage() {
        showMessage("Упс... Что-то введено неверно или вообще не введено!")
    }

    override fun getLogin() = findViewById<EditText>(R.id.edtLogin).text.toString()

    override fun getPassword() = findViewById<EditText>(R.id.edtPassword).text.toString()

    override fun getConfirmedPassword()
                = findViewById<EditText>(R.id.edtConfirmationPassword).text.toString()

    override fun getEmail() = findViewById<EditText>(R.id.edtEmail).text.toString()

    override fun getPatronymic() = findViewById<EditText>(R.id.edtPatronymic).text.toString()

    override fun getName() = findViewById<EditText>(R.id.edtName).text.toString()

    override fun getSurname() = findViewById<EditText>(R.id.edtSurname).text.toString()

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun getUser(): UserModel {
        val user: UserModel = UserModel(getLogin(), getPassword())
        user.name = getName()
        user.surname = getSurname()
        user.patronymic = getPatronymic()
        user.email = getEmail()

        return user
    }
}