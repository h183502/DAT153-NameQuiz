package com.example.namequiz

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    public fun onClickDatabase(view: View){
        val database = Intent(this, DbActivity::class.java)

        startActivity(database)
    }

    public fun onClickAdd(view: View){
        val addActivity = Intent(this, AddActivity::class.java)

        startActivity(addActivity)
    }

    public fun onClickQuiz(view: View){
        val quiz = Intent(this, quizActivity::class.java)

        startActivity(quiz)
    }
}
