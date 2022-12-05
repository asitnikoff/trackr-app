package main.trackr.views.interfaces

import android.widget.TextView

interface ProfileView {
    fun setProfileData()
    fun getUsernameTextView(): TextView
    fun getNameTextView(): TextView
    fun getSurnameTextView(): TextView
    fun getPatronymicTextView(): TextView
    fun getEmailTextView(): TextView
    fun getPasswordTextView(): TextView
//    fun getPhoneNumberTextView(): TextView
    fun setUserFromPref()
}