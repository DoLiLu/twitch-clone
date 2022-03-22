package com.example.user.application.service

import com.example.user.application.port.`in`.UpdateUserCommand
import com.example.user.application.port.`in`.UpdateUserUseCase
import com.example.user.application.port.out.UserRepository
import com.example.user.domain.model.User

internal class UpdateUserService(private val userRepository: UserRepository) : UpdateUserUseCase {

    /**
     * - 현재 변경 가능한 필드는 nickname만 입니다.
     * - 항상 새로운 객체를 만듭니다.
     */
    override fun updateUser(updateUserCommand: UpdateUserCommand): User {
        return with(updateUserCommand) {
            userRepository.findById(id).let {
                userRepository.save(
                    User(
                        id = it.id, email = it.email, password = it.password,
                        nickname = nickname ?: it.nickname
                    )
                )
            }
        }
    }
}