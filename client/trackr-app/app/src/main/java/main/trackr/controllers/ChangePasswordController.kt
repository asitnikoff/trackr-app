package main.trackr.controllers

import main.trackr.models.UserModel
import main.trackr.models.requests.UserRequest
import main.trackr.views.interfaces.ChangePasswordView

class ChangePasswordController {
    private lateinit var view: ChangePasswordView
    private val userRequest: UserRequest = UserRequest()

    fun bind(view: ChangePasswordView) {
        this.view = view
    }

    fun updateUserPassword(user: UserModel, handler: () -> Unit) {
        val password: String? = view.getPassword()
        val confirmPassword: String? = view.getConfirmPassword()

        if ((password != null) && (password == confirmPassword)) {
            user.password = password
            userRequest.updateUser(user) {
                handler()
            }
        }
    }
}