package com.lucayeray.cafeteriapoject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.lucayeray.cafeteriapoject.databinding.ActivityLoginBinding
import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import com.lucayeray.cafeteriapoject.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        loginViewModel = ViewModelProvider(this)
            .get(LoginViewModel::class.java)

        binding.botoAcceptLogin.setOnClickListener {

            val username = binding.labelUsuari.text.toString()
            val password = binding.labelContra.text.toString()

            if (username.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show()
            }

            loginViewModel.login(this, username, password)
                .observe(this) { user ->

                    if (user != null) {

                        Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show()

                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        binding.botoRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}