package main.trackr.views.interfaces

import main.trackr.models.UserModel

interface AuthView {
    fun getLogin(): String
    fun getPassword(): String
    fun showMessage(message: String)
    fun successfullyAuthorized(user: UserModel)
    fun unsuccessfullyAuthorized()
}