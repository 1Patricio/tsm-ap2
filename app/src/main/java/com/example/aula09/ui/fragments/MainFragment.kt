package com.example.aula09.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.aula09.R
import com.example.aula09.data.TodoRepository
import com.example.aula09.ui.adapter.TodoAdapter

class MainFragment : Fragment() {
    val todoRepository = TodoRepository()
    private lateinit var adapter: TodoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Preciso criar a instancia do adapter
        adapter = TodoAdapter(
            onDelete = { todo ->
                val newList = todoRepository.todoList.toMutableList()
                newList.remove(todo)
                todoRepository.todoList = newList
                adapter.submitList(newList)
                true
            }, actionView = { todo ->

                val action =
                    MainFragmentDirections.actionMainFragmentToDetailsFragment(todo)

                findNavController().navigate(action)
            })

        // Preciso recuperar a recyclerview
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler)

        // Preciso linkar a recyclerview com o adapter
        recyclerView.adapter = adapter

        // Preciso submter os dados pra lista
        adapter.submitList(todoRepository.todoList)
    }
}