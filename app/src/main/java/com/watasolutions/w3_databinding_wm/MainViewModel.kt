package com.watasolutions.w3_databinding_wm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class Error {
    ERROR_EMAIL,
    ERROR_PASSWORD,
}

class Resp(val isSuccess: Boolean, val error: Error?)

class MainViewModel : ViewModel() {
    private var _isSuccessEvent: MutableLiveData<Boolean> = MutableLiveData()
    val isSuccessEvent: LiveData<Boolean>
        get() = _isSuccessEvent

    private var _isErrorEvent: MutableLiveData<String> = MutableLiveData()
    val isErrorEvent: LiveData<String>
        get() = _isErrorEvent

    fun checkEmailAndPassword(email: String, password: String) {
        //kiem tra format email
        val isValidEmail = isEmailValid(email)
        if (!isValidEmail) {
            _isErrorEvent.postValue("email không hợp lệ")
            return
        }
        //password length > 8 && < 10
        val isValidPassword = isPasswordValid(password)
        if (!isValidPassword) {
            _isErrorEvent.postValue("password không hợp lệ")
            return
        }
        //call API login
        //val isSuccess = DataRepo.login(email = email, pass = password)

        _isSuccessEvent.postValue(true)
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length in 8..10
    }
}