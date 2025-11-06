package com.example.aula09.ui.adapter

import androidx.recyclerview.widget.ListAdapter
import com.example.aula09.data.Todo

class TodoAdapter(
    private val actionView: (Todo) -> Unit,
    private val onDelete: (Todo) -> Boolean,
) : ListAdapter<Todo, TodoViewHolder>(TodoDiffCallback()) {
    override fun onCreateViewHolder(parent: android.view.ViewGroup, viewType: Int): TodoViewHolder {
        val itemView = android.view.LayoutInflater.from(parent.context)
            .inflate(com.example.aula09.R.layout.todo_item_list, parent, false)
        return TodoViewHolder(itemView, onDelete, actionView)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bind(todo)

        holder.itemView.setOnClickListener {
            actionView(todo)
        }
    }
}