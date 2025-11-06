package com.example.aula09

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.aula09.data.TodoRepository
import com.example.aula09.ui.adapter.TodoAdapter


class MainActivity : AppCompatActivity() {

    val todoRepository = TodoRepository()
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Preciso criar a instancia do adapter
        adapter = TodoAdapter(
            onDelete = { todo ->
                val newList = todoRepository.todoList.toMutableList()
                newList.remove(todo)
                todoRepository.todoList = newList
                adapter.submitList(newList)
                true
            }, actionView = { todo ->
                val intent = Intent(this, DetailsActivity::class.java).apply {
                    this.putExtras(bundleOf("todo" to todo))
                }
                startActivity(intent)
            })

        // Preciso recuperar a recyclerview
        val rc = findViewById<RecyclerView>(R.id.recycler)

        // Preciso linkar a recyclerview com o adapter
        rc.adapter = adapter

        // Preciso submter os dados pra lista
        adapter.submitList(todoRepository.todoList)
    }
}