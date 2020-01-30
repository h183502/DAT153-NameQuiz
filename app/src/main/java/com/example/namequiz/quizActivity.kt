package com.example.namequiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.core.view.isInvisible
import kotlinx.android.synthetic.main.quiz.*

class quizActivity : AppCompatActivity() {

    lateinit var quiz: Quiz
    lateinit var data: ArrayList<Kittens>

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

    private fun runRound(){
        val kitten = quiz.pickKitten()
        imageViewQuiz.setImageBitmap(kitten.image)
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
        inputAnswer.setText("")

        if (!quiz.isDone()){
            runRound()
        }else{
            Toast.makeText(this, "Yee-haaw, you've done it!", Toast.LENGTH_SHORT).show()
            submitAns.visibility = View.INVISIBLE
            restartBtn.visibility = View.VISIBLE


        }
    }


}
