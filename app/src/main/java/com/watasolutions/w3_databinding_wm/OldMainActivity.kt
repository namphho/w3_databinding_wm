package com.watasolutions.w3_databinding_wm

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.watasolutions.w3_databinding_wm.databinding.ActivityMainBinding

class OldMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.btnLogin.setOnClickListener {
            val email : String = binding.edtEmail.text.toString().trim()
            val password : String = binding.edtPassword.text.toString().trim()
            val formattedEmail: String = email.replace(" ", "*")
            binding.tvResult.text = "email: ${formattedEmail} - password: $password"

            //showAlertDialog(formattedEmail)
        }

    }

    ///show toast
    fun showToast() {
        Toast.makeText(
            this,
            "this is toast", Toast.LENGTH_SHORT
        ).show()
    }


    ///show alert dialog
    fun showAlertDialog(result: String) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Androidly Alert")
        builder.setMessage("We have a message")
        builder.setPositiveButton("Đồng Ý") { dialog, which ->
            Toast.makeText(
                applicationContext,
                result, Toast.LENGTH_SHORT
            ).show()
        }

        builder.setNegativeButton("Hủy") { dialog, which ->
            Toast.makeText(
                applicationContext,
                android.R.string.no, Toast.LENGTH_SHORT
            ).show()
        }

        builder.show()
    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }


}