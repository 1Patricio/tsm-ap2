package com.example.aula09.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.example.aula09.R

class DetailsFragment : Fragment() {
    val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val todo = args.todo

        view.findViewById<TextView>(R.id.idTodo).text = todo.id.toString()
        view.findViewById<TextView>(R.id.todoTitle).text = todo.title
        view.findViewById<TextView>(R.id.taskDescription).text = todo.description
    }
}