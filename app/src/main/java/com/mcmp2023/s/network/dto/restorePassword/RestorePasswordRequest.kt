package com.mcmp2023.s.network.dto.restorePassword

data class RestorePasswordRequest(
    val email: String,
    val code: String,
    val newPassword: String
)