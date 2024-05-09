package com.itson.giftapp.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itson.giftapp.databinding.ActivityRegisterBinding
import com.itson.giftapp.view.MainActivity
import com.itson.giftapp.data.UserRepository

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if (UserRepository.registerUser(name, email, password)) {
                // Si el registro es exitoso, navega a la actividad principal
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Muestra un mensaje de error si el correo electrónico ya está registrado
            }
        }

        binding.tvLogin.setOnClickListener {
            // Navega a la actividad de inicio de sesión si el usuario ya tiene una cuenta
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun isValidRegistration(name: String, email: String, password: String): Boolean {
        // Aquí debes implementar la lógica para validar los datos del registro
        // Por ejemplo, puedes verificar que todos los campos estén completos y que el formato del correo electrónico sea válido
        return name.isNotBlank() && email.isNotBlank() && password.isNotBlank()
    }
}
