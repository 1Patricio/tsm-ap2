package com.example.aula09.ui.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import com.example.aula09.data.Todo

class TodoDiffCallback : DiffUtil.ItemCallback<Todo>() {

    // Verifica se os IDs dos itens são iguais
    override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem.id == newItem.id
    }

    // Verifica se o conteúdo do item mudou
    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
        return oldItem == newItem // Usa o equals da data class
    }
}