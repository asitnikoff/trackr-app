package com.example.trackr_app

class GlobalData {
    companion object {
        @JvmStatic
        var user = User("admin", "admin", 0)
        @JvmStatic val users = mutableListOf(
            user
        )
    }
}