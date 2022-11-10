package main.trackr.controllers

import main.trackr.models.UserModel
import main.trackr.views.interfaces.RegistrationView

class RegistrationController() {
    private lateinit var user: UserModel

    fun registrationSuccessful(view: RegistrationView): Boolean {
        val newUser: UserModel = view.getUser()
        if (isValidUserData(newUser) &&
            isPasswordConfirmed(view)) {
                newUser.addUser()
                return true
        }
        return false
    }

    private fun isPasswordConfirmed(view: RegistrationView): Boolean {
        return ((view.getConfirmedPassword() != "") &&
                (view.getPassword() == view.getConfirmedPassword()))
    }

    private fun isValidUserData(newUser: UserModel): Boolean {
        return (!newUser.login.isEmpty() &&
                !newUser.password.isEmpty() &&
                !newUser.name.isEmpty() &&
                !newUser.surname.isEmpty() &&
                !newUser.patronymic.isEmpty() &&
                isValidEmail(newUser.email))
    }

    private fun isValidEmail(email: String): Boolean {
        return !email.isEmpty()
    }
}