package com.example.aula09.ui.adapter

import android.graphics.Paint
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aula09.R
import com.example.aula09.data.Todo
import com.google.android.material.checkbox.MaterialCheckBox

class TodoViewHolder(
    itemView: View,
    private val onDelete: (Todo) -> Boolean,
    private val onClick: (Todo) -> Unit
) : RecyclerView.ViewHolder(itemView) {
    private val title: TextView = itemView.findViewById(R.id.titleTodo)
    private val description: TextView = itemView.findViewById(R.id.todoTaskDescription)
    private val isCheck: MaterialCheckBox = itemView.findViewById(R.id.todoCheck)

    private val actionView: TextView = itemView.findViewById(R.id.actionView)
    private val actionDelete: TextView = itemView.findViewById(R.id.actionDelete)

    fun bind(todo: Todo) {
        title.text = todo.title
        description.text = todo.description
        isCheck.isChecked = todo.isCompleted

        actionView.setOnClickListener {
            Log.i("Click", "Fui clicado, ${todo.id}")
            onClick(todo)
        }

        actionDelete.setOnLongClickListener {
            Log.i("Click", "Deletar, ${todo.id}")
            onDelete(todo)
        }
        paintTaskCheked()
    }

    private fun paintTaskCheked() {
        this.isCheck.addOnCheckedStateChangedListener { checkBox, state ->
            if (checkBox.isChecked) {
                this.title.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.description.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.actionView.visibility = View.GONE
                this.actionDelete.visibility = View.GONE
            } else {
                this.title.paintFlags = 0
                this.description.paintFlags = 0
                this.actionView.visibility = View.VISIBLE
                this.actionDelete.visibility = View.VISIBLE
            }
        }
    }
}