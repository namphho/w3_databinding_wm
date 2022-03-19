package com.watasolutions.w3_databinding_wm

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Student(val username: String, val password: String) : Parcelable {
}