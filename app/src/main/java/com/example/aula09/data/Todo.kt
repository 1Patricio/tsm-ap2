package com.example.aula09.data

import java.io.Serializable

class Todo(
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean,
    val date: String,
    val user: String
) : Serializable