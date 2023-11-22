package com.example.examensegundoparcial.Model

data class User (val gender: String,
                 val name: Name,
                 val location: Location,
                 val email: String,
                 val login: Login,
                 val dob: Dob,
                 val registered: Dob,
                 val phone: String)

data class Name(
    val title: String,
    val first: String,
    val last: String
)
data class Location(
    val city: String,
    val state: String,
    val country: String,
)
data class Dob(
    val date: String,
    val age: String,
)

data class Login(
    val password: String
)