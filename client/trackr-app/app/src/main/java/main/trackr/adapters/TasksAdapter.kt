package main.trackr.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import main.trackr.models.TaskModel

class TasksAdapter(context: Context, @LayoutRes val layoutRes: Int, tasks: MutableList<TaskModel>)
    : ArrayAdapter<TaskModel>(context, layoutRes, tasks) {

    override fun getView(position: Int, converterView: View?, parent: ViewGroup): View {
        val currentTaskModel: TaskModel? = getItem(position)

        var currentView: View? = converterView

        if (currentView == null) {
            currentView = LayoutInflater.from(context)
                .inflate(
                    android.R.layout.simple_list_item_2,
                    parent,
                    false)
            currentView!!
        }

        val textView1: TextView = currentView.findViewById(android.R.id.text1)
        val textView2: TextView = currentView.findViewById(android.R.id.text2)

//        textView1.text = currentTaskModel?.name
//        textView2.text = currentTaskModel?.author!!.login

        return currentView
    }
}