package com.example.namequiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.quiz.*

class quizActivity : AppCompatActivity() {

    lateinit var quiz: Quiz
    lateinit var data: ArrayList<Kittens>
    lateinit var currentKitten: Kittens

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)
        data = (application as KittenApp).data
        quiz = Quiz(data)

        inputAnswer.setOnKeyListener(View.OnKeyListener {v, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP){
                if (!quiz.done){
                    submitAnswer(inputAnswer)
                }
                return@OnKeyListener true
            }
            false
        })
        runRound()
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

    private fun runRound(){
        val kitten = quiz.pickKitten()
        imageViewQuiz.setImageBitmap(kitten.image)
        currentKitten = kitten
    }

    fun restart(view: View){
        quiz = Quiz(data)
        restartBtn.visibility = View.INVISIBLE
        submitAns.visibility = View.VISIBLE
        textKittens.text = "0"
        yourScore.text = "0"
        runRound()

    }

    fun submitAnswer(view: View){
        val isCorrect = quiz.answer(inputAnswer.text.toString())
        textKittens.text = quiz.attempts.toString()
        yourScore.text = quiz.score.toString()
        displayFeedback(isCorrect)
        inputAnswer.setText("")

        if (!quiz.isDone()){
            runRound()
        }else{
            Toast.makeText(this, "Yee-haaw, you've done it!", Toast.LENGTH_SHORT).show()
            submitAns.visibility = View.INVISIBLE
            restartBtn.visibility = View.VISIBLE


        }
    }

    private fun displayFeedback(isCorrect: Boolean){
        if(isCorrect){
            textFeedback.visibility = View.VISIBLE
        }else {
            val msg = "Wrong answer! Correct answer was ${currentKitten.name}"
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        }
    }


}
