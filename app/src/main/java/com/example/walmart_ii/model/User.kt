package com.example.walmart_ii.model

import java.io.Serializable

data class User(var firstName: String, var lastName: String, var username: String, var password: String) : Serializable {
}