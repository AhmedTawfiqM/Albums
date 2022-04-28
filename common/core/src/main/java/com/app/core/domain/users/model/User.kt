package com.app.core.domain.users.model

data class User(
    val id: Int = 0,
    val website: String = "",
    val address: Address,
    val phone: String = "",
    val name: String = "",
    val company: Company,
    val email: String = "",
    val username: String = ""
)