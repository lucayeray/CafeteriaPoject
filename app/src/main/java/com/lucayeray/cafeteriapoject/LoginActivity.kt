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

        // 🔹 OBSERVER (OBLIGATORIO)
        loginViewModel.loginCorrecto.observe(this) { correcto ->
            if (correcto) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(
                    this,
                    "Usuario o contraseña incorrectos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.botoAcceptLogin.setOnClickListener {
            val username = binding.labelUsuari.text.toString()
            val password = binding.labelContra.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                loginViewModel.login(this, username, password)
            } else {
                Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        // 🔹 BOTÓN REGISTER
        binding.botoRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
