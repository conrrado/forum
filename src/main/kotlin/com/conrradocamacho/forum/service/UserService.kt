package com.conrradocamacho.forum.service

import com.conrradocamacho.forum.model.User
import org.springframework.stereotype.Service

@Service
class UserService(final var users: List<User>) {

    init {
        val user = User(
            id = 1,
            name = "Maria",
            email = "maria@email.com"
        )

        users = listOf(user)
    }

    fun searchById(id: Long): User {
        return users.stream().filter { it.id == id }.findFirst().get()
    }

}
