package com.itson.giftapp.data

object UserRepository {
    private val users = mutableListOf<User>()
    private var currentUser: User? = null

    fun registerUser(name: String, email: String, password: String): Boolean {
        // Verifica si el correo electrónico ya está registrado
        if (users.any { it.email == email }) {
            return false
        }

        // Crea un nuevo usuario y agrega a la lista
        val newUser = User(name, email, password)
        users.add(newUser)
        return true
    }
    fun getCurrentUser(): User? {
        return currentUser
    }

    fun loginUser(email: String, password: String): Boolean {
        // Busca un usuario con el correo electrónico y la contraseña proporcionados
        val user = users.find { it.email == email && it.password == password }
        if (user != null) {
            currentUser = user
            return true
        }
        return false
    }

    fun isUserLoggedIn(): Boolean {
        return currentUser != null
    }
}