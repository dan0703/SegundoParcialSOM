package com.example.examensegundoparcial.Model

import android.widget.Toast
import com.example.examensegundoparcial.core.ServiceBuilder

class UserProvider {
    companion object {
         suspend fun getNewUser(): User {
            val user = ServiceBuilder.userService.getUser()
             println("Respuesta" + user)
            return user
        }
    }
}