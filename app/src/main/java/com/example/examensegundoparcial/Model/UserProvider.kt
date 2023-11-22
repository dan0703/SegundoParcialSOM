package com.example.examensegundoparcial.Model

import android.widget.Toast
import com.example.examensegundoparcial.core.ServiceBuilder
import okhttp3.ResponseBody

class UserProvider {
    companion object {
         suspend fun getNewUser(): Result {
            val user: UserData = ServiceBuilder.userService.getUser()
             if (user.results.isNotEmpty()) {
                 val firstResult: Result = user.results[0]

                 val name: String = "${firstResult.name.first} ${firstResult.name.last}"
                 val email: String = firstResult.email
             } else {
                 println("No se encontraron resultados en la respuesta.")
             }
            return user.results[0]
        }
    }
}