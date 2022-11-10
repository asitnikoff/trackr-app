package main.trackr.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import main.trackr.R
//import main.trackr.models.GlobalDataModel.Companion.user

class ProfileActivity : AppCompatActivity() {
    private lateinit var btnChangePassword: Button
    private lateinit var btnExit: Button
    private lateinit var tvUsername: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnChangePassword = findViewById(R.id.btnChangePassword)
        btnExit = findViewById(R.id.btnExit)

        btnChangePassword.setOnClickListener {
            intent = Intent(this, ChangePasswordActivity::class.java);
            startActivity(intent)
        }

        btnExit.setOnClickListener {
            intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        tvUsername = findViewById(R.id.tvUsername)
//        tvUsername.text = user.login
    }
}