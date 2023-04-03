package com.watasolutions.w3_databinding_wm

class DataRepo {

    companion object {
        fun login(email: String, pass: String) : Boolean {
            if (email == "ronaldo@gmail.com" && pass == "12345678@X") {
                return true
            }
            return false
        }
    }

}