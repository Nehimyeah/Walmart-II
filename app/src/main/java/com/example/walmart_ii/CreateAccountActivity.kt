package com.example.walmart_ii

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.example.walmart_ii.model.User

class CreateAccountActivity : AppCompatActivity() {
    private lateinit var firstNameTxt: EditText
    private lateinit var lastNameTxt: EditText
    private lateinit var usernameTxt: EditText
    private lateinit var passwordTxt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        firstNameTxt = findViewById(R.id.firstName)
        lastNameTxt = findViewById(R.id.lastName)
        usernameTxt = findViewById(R.id.email)
        passwordTxt = findViewById(R.id.pass)
    }

    fun createUser(view: View) {
        val user = User(
            firstNameTxt.text.toString(),
            lastNameTxt.text.toString(),
            usernameTxt.text.toString(),
            passwordTxt.text.toString()
        )
        val rIntent = Intent()
        rIntent.putExtra("user", user);
        setResult(Activity.RESULT_OK, rIntent)
        finish()
    }
}