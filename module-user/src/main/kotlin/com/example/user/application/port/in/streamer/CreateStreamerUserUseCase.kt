package com.example.user.application.port.`in`.streamer

import com.example.user.domain.model.NormalUser
import com.example.user.domain.model.StreamerUser
import java.util.*

interface CreateStreamerUserUseCase {

    fun createStreamerUser(createStreamerUserCommand: CreateStreamerUserCommand): StreamerUser
}

data class CreateStreamerUserCommand(
    val normalUser: NormalUser,
    val streamerUserNickname: String,
    val subscriptionCost: Int
) {
    val id: UUID
        get() {
            return normalUser.id
        }
}