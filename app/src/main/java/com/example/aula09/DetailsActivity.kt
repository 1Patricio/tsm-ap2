package com.example.aula09

import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.aula09.data.Todo

class DetailsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val todo = intent.extras?.getSerializable<Todo>("todo", Todo::class.java)

        val id = findViewById<TextView>(R.id.idTodo)
        val title = findViewById<TextView>(R.id.todoTitle)
        val description = findViewById<TextView>(R.id.taskDescription)

        id.text = todo?.id.toString()
        title.text = todo?.title.toString()
        description.text = todo?.description
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}