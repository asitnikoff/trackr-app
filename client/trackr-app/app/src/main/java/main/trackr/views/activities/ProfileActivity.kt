package main.trackr.views.activities

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.gson.Gson
import main.trackr.R
import main.trackr.models.UserModel
import main.trackr.views.interfaces.ProfileView

class ProfileActivity : AppCompatActivity(), ProfileView {
    private lateinit var btnChangePassword: Button
    private lateinit var btnExit: Button
    private lateinit var globalPref: SharedPreferences
    private val gson = Gson()
    private lateinit var user: UserModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        globalPref = this.getSharedPreferences("global", Context.MODE_PRIVATE)
        setUserFromPref()

        btnChangePassword = findViewById(R.id.btnChangePassword)
        btnExit = findViewById(R.id.btnExit)

        setProfileData()

        btnChangePassword.setOnClickListener {
            intent = Intent(this, ChangePasswordActivity::class.java);
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }
    }

    private fun updateUser() {
        user = gson.fromJson(
            globalPref.getString("authUser", "{}"),
            UserModel::class.java
        )
    }

    override fun onResume() {
        super.onResume()
        updateUser()
        setProfileData()
    }

    override fun setProfileData() {
        val tvUsername: TextView = getUsernameTextView()
        val tvName: TextView = getNameTextView()
        val tvSurname: TextView = getSurnameTextView()
        val tvPatronymic: TextView = getPatronymicTextView()
        val tvEmail: TextView = getEmailTextView()
        val tvPassword: TextView = getPasswordTextView()
//        val tvPhoneNumber: TextView = getPhoneNumberTextView()

        tvUsername.text = user.login
        tvName.text = user.name
        tvSurname.text = user.surname
        tvPatronymic.text = user.patronymic
        tvEmail.text = user.email
        tvPassword.text = user.password
//        tvPhoneNumber.text = user.phoneNumber
    }

    override fun getPasswordTextView(): TextView = findViewById(R.id.tvPassword)

    override fun getUsernameTextView(): TextView = findViewById(R.id.tvUsername)

    override fun getNameTextView(): TextView = findViewById(R.id.tvName)

    override fun getSurnameTextView(): TextView = findViewById(R.id.tvSurname)

    override fun getPatronymicTextView(): TextView = findViewById(R.id.tvPatronymic)

    override fun getEmailTextView(): TextView = findViewById(R.id.tvEmail)

//    override fun getPhoneNumberTextView(): TextView = findViewById(R.id.tvPhoneNumber)

    override fun setUserFromPref() {
        val userJson: String? = globalPref.getString("authUser", "bad :((")
        if (userJson == null) {
            println("something bad")
            return
        }
        user = gson.fromJson(userJson, UserModel::class.java)
    }
}