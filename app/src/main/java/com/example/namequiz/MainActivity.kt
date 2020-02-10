package com.example.namequiz

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.preference.PreferenceManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.settings){
            Intent(this, setNameActivity::class.java).also {
                startActivity(it)
            }
        }
        return super.onOptionsItemSelected(item)
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
