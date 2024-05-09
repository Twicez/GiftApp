package com.itson.giftapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.itson.giftapp.R
import com.itson.giftapp.databinding.ActivityProfileBinding
import com.itson.giftapp.data.UserRepository

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener el usuario actual de UserRepository
        val currentUser = UserRepository.getCurrentUser()

        // Actualizar los elementos de la interfaz de usuario con los datos del usuario
        binding.tvName.text = currentUser?.name
        binding.tvEmail.text = currentUser?.email
        // Puedes cargar la imagen desde un recurso o una URL
        binding.ivProfilePicture.setImageResource(R.drawable.amigo1)
    }
}