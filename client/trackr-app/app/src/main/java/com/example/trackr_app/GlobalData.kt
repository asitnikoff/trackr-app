package com.example.trackr_app

class GlobalData {
    companion object {
        @JvmStatic
        var user = User("admin", "admin", 0)

        @JvmStatic
        val users = mutableListOf(
            user
        )

        @JvmStatic
        val tasks = mutableListOf<Task>(
            Task("Сделать ленту", User("admin", "admin", 0), "Instagram")
        )
    }
}