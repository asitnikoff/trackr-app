package main.trackr.controllers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import main.trackr.models.UserModel
import main.trackr.models.requests.UserRequest
import main.trackr.views.interfaces.RegistrationView

class RegistrationController() {
    private lateinit var user: UserModel
    private lateinit var view: RegistrationView
    private val userRequest: UserRequest = UserRequest()

    fun bind(view: RegistrationView) {
        this.view = view
    }

    private fun getUserFromDatabase(): UserModel? {
        var retUser: UserModel? = null

        userRequest.getUser(user.login) {
            retUser = it
        }

        return retUser
    }

    suspend fun addUserToDatabase() {
        user.addUser()
    }

    fun register() {
        CoroutineScope(Dispatchers.IO).launch {
            val dbUser: UserModel? = getUserFromDatabase()
            user = view.getUser()
            checkRegistrationData()
            withContext(Dispatchers.Main) {
                if (dbUser == null) {
                    view.registrationSuccessful()
                } else {
                    view.registrationUnsuccessful()
                }
            }
        }
    }

    private fun checkRegistrationData(): Boolean {
        if (!isValidUserData()) {
            view.showMessage("Упс... Что-то введено неверно или вообще не введено!")
            return false
        }

        if (!isPasswordConfirmed()) {
            view.showMessage("Пароль не подтвержден или пароль повторно введен неверно")
            return false
        }

        return true
    }

    private fun isPasswordConfirmed(): Boolean {
        return ((view.getConfirmedPassword() != "") &&
                (view.getPassword() == view.getConfirmedPassword()))
    }

    private fun isValidUserData(): Boolean {
        return (user.login.isNotEmpty() &&
                user.password.isNotEmpty() &&
                user.name.isNotEmpty() &&
                user.surname.isNotEmpty() &&
                user.patronymic.isNotEmpty() &&
                isValidEmail(user.email))
    }

    private fun isValidEmail(email: String): Boolean {
        return email.isNotEmpty()
    }
}