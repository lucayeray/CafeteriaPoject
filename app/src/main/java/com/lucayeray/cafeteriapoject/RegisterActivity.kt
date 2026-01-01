package com.lucayeray.cafeteriapoject

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.lucayeray.cafeteriapoject.databinding.ActivityRegisterBinding
import androidx.lifecycle.ViewModelProvider
import com.lucayeray.cafeteriapoject.viewModel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    private lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        registerViewModel = ViewModelProvider(this)
            .get(RegisterViewModel::class.java)

        binding.botoAcceptRegist.setOnClickListener {

            val username = binding.labelUsuariRegist.text.toString()
            val password = binding.labelContraRegist.text.toString()

            if (username.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Campos vacíos", Toast.LENGTH_SHORT).show()
            }

            registerViewModel.registerUser(this, username, password)

            Toast.makeText(this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show()
            finish()
        }

        binding.botoLoginRegist.setOnClickListener {
            finish()
        }

    }
}