package com.example.examensegundoparcial.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.examensegundoparcial.R
import com.example.examensegundoparcial.ViewModel.UserViewModel
import com.example.examensegundoparcial.core.ServiceBuilder
import com.example.examensegundoparcial.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    private val userViewModel:UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initObservables()
        initListeners()
    }

    private fun initListeners() {
        binding.btnNewUser.setOnClickListener {
            lifecycleScope.launch {
                userViewModel.getNewUser()
            }
        }
    }

    private fun initObservables() {
        userViewModel.userModel.observe(this, Observer { user ->
            binding.tvUserName.text = user.name.first
            binding.tvEmail.text = user.email
            binding.tvBirthDay.text = user.dob.age
            binding.tvDirection.text = user.location.city + ", " + user.location.state + ", " + user.location.country
            binding.tvNumber.text = user.phone
            binding.tvPassword.text = user.login.password
        })    }
}