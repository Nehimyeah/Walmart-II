package com.example.walmart_ii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.walmart_ii.R

class ShoppingActivity : AppCompatActivity() {
    private lateinit var userNameTxt: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        userNameTxt = findViewById(R.id.userName)

        userNameTxt.text = intent.getStringExtra("username")
    }
}