package main.trackr.views.interfaces

import main.trackr.models.UserModel

interface RegistrationView {
    fun getLogin(): String
    fun getPassword(): String
    fun getConfirmedPassword(): String
    fun getUser(): UserModel
    fun getName(): String
    fun getSurname(): String
    fun getPatronymic(): String
    fun getEmail(): String
    fun showMessage(message: String)
    fun registrationUnsuccessful()
    fun registrationSuccessful()
}