package main.trackr.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import main.trackr.R
import main.trackr.models.TaskModel
import main.trackr.models.UserModel

class AddTaskActivity : AppCompatActivity() {
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        button = findViewById(R.id.btnAddTask)

        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.edtText)
//            GlobalDataModel.tasks.add(
//                TaskModel(
//                    editText.text.toString(),
//                    getAuthUser(),
//                    intent.extras!!.get("projectName").toString()
//                )
//            )
//            ProjectActivity.tasks.add(GlobalDataModel.tasks.last())
            ProjectActivity.adapter.notifyDataSetChanged()
            this.finish()
        }
    }

    private fun getAuthUser(): UserModel {
//        return GlobalDataModel.user
        return UserModel("empty", "empty")
    }
}