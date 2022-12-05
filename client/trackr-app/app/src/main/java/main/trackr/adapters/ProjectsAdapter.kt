package main.trackr.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.annotation.LayoutRes
import main.trackr.models.ProjectModel
import main.trackr.models.TaskModel

class ProjectsAdapter(context: Context, @LayoutRes val layoutRes: Int, tasks: List<ProjectModel>)
    : ArrayAdapter<ProjectModel>(context, layoutRes, tasks) {

    override fun getView(position: Int, converterView: View?, parent: ViewGroup): View {
        val currentProject: ProjectModel = getItem(position)!!

        var currentView: View? = converterView

        if (currentView == null) {
            currentView = LayoutInflater.from(context)
                .inflate(
                    android.R.layout.simple_list_item_1,
                    parent,
                    false)
            currentView!!
        }

        val textView1: TextView = currentView.findViewById(android.R.id.text1)

        textView1.text = currentProject.projectName

        return currentView
    }
}