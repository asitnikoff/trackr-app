package main.trackr.views.interfaces

interface ChangePasswordView {
    fun getPassword(): String?
    fun getConfirmPassword(): String?
}