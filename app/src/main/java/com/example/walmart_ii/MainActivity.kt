package com.example.walmart_ii

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ShareCompat
import com.example.walmart_ii.model.User

class MainActivity : AppCompatActivity() {
    private lateinit var emailTxt: EditText
    private lateinit var passTxt: EditText


    private val users: MutableList<User> = mutableListOf(
        User("Nehemiah", "Tefera", "nehemiah.tefera1@gmail.com", "1"),
        User("Ruth", "Tefera", "ruth.tefera@gmail.com", "1"),
        User("Nabon", "Tefera", "nabon.tefera@gmail.com", "1"),
        User("Nebiyat", "Yoseph", "nebiyat.yoseph@gmail.com", "1"),
        User("Amanuel", "Tefera", "amanuel.tefera@gmail.com", "1")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        emailTxt = findViewById(R.id.email)
        passTxt = findViewById(R.id.pass)
    }

    private var resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val user = it.data?.getSerializableExtra("user") as User
            users.add(user)
        } else {
            Toast.makeText(this, "No User data given", Toast.LENGTH_SHORT).show()
        }
    }

    fun signIn(view: View) {
        val user = users.find { it.username == emailTxt.text.toString() && it.password == passTxt.text.toString() }
        if (user != null ) {
            val intent = Intent(this, ShoppingActivity::class.java)
            intent.putExtra("username", user.username)
            startActivity(intent)
        } else {
            Toast.makeText(this, "This not a valid user! retry", Toast.LENGTH_SHORT).show()
        }
    }

    fun createAccount(view: View) {
        val intent = Intent(this, CreateAccountActivity::class.java)
        resultContract.launch(intent)
    }

    fun forgotPass(view: View) {
        val pass = "what the hell man"
        val email = "nehemiah.tefera1@gmail.com"
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + email))
        intent.putExtra(Intent.EXTRA_SUBJECT, "Reset password")
        intent.putExtra(Intent.EXTRA_TEXT, pass)
        startActivity(Intent.createChooser(intent, "Send Email through"))
    }
}