package main.trackr.views.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import main.trackr.R
import main.trackr.controllers.AuthController
import main.trackr.models.TaskModel

class AuthActivity : AppCompatActivity() {
    private val btnRegistration: Button by lazy { findViewById(R.id.btnRegister) }
    private val logInButton: Button by lazy { findViewById(R.id.btnLogIn) }
    private val controller: AuthController by lazy { AuthController() }
    private lateinit var data: List<TaskModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authorization)

//        val tasks: TasksApi = api.create(TasksApi::class.java)
//        api.create(TasksApi::class.java).tasks().enqueue(object: Callback<List<TaskModel>> {
//            override fun onResponse(
//                call: Call<List<TaskModel>>,
//                response: Response<List<TaskModel>>
//            ) {
//                println("SUCCESS!!!")
//                data = response.body()!!
//                println(data.get(0).task_title)
//            }
//
//            override fun onFailure(call: Call<List<TaskModel>>, t: Throwable) {
//                println(t.message)
//            }
//        })

        logInButton.setOnClickListener {
            if (controller.checkCredentialsData(
                findViewById(R.id.edtLogin),
                findViewById(R.id.edtPassword)
            )) {
                changeActivity(HomeActivity::class.java)
            }
        }

        btnRegistration.setOnClickListener {
            changeActivity(RegistrationActivity::class.java)
        }
    }

    private fun changeActivity(newActivity: Class<*>) {
        val intent = Intent(this, newActivity)
        startActivity(intent)
    }
}