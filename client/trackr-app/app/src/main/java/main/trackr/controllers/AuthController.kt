package main.trackr.controllers

import android.widget.EditText
import main.trackr.models.GlobalDataModel
import main.trackr.models.UserModel

class AuthController {
    fun checkCredentialsData(loginEditText: EditText, passwordEditText: EditText): Boolean {
        val login = loginEditText.text.toString()
        val password = passwordEditText.text.toString()

        val currentUser: UserModel? = getUserByCredentials(login, password)
        if (currentUser != null) {
//            GlobalDataModel.user = currentUser
            return true;
        }
        return false
    }

    private fun getUserByCredentials(login: String, password: String): UserModel? {
//        for (currentUser in GlobalDataModel.users) {
//            if ((currentUser.login == login) &&
//                (currentUser.password == password)) {
//                return currentUser
//            }
//        }
        return null
    }
}