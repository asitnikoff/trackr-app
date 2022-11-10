package main.trackr.models

import java.util.Date

class TaskModel {
    var taskId: Int = 0
    lateinit var taskTitle: String
    lateinit var taskSlug: String
    lateinit var tags: MutableList<TagModel>
    lateinit var description: String
    lateinit var createDate: Date
    lateinit var endDate: Date
    lateinit var startDate: Date
    lateinit var closeDate: Date
    lateinit var performer: UserModel
    lateinit var author: UserModel
    lateinit var priority: PriorityModel
    var is_open: Boolean = true
    lateinit var project: ProjectModel
}