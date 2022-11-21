package main.trackr.views.interfaces

interface AuthView {
    fun getLogin(): String
    fun getPassword(): String
    fun showMessage(message: String)
    fun successfullyAuthorized()
    fun unsuccessfullyAuthorized()
}