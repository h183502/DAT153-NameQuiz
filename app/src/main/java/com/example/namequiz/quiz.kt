package com.example.namequiz

class Quiz (data: ArrayList<Kittens>){

    var score: Int
    var attempts: Int
    var done: Boolean
    var index: Int
    var kittens: ArrayList<Kittens>

    init {
        score = 0
        attempts = 0
        done = false
        index = 0
        kittens = data
        data.shuffle()
    }

    fun answer(ans: String): Boolean{
        attempts++
        var correct = false
        if (ans.equals(kittens[index].name, true)){
            score++
            correct = true
        }
        index++
        done = isDone()
        return correct
    }

    fun isDone(): Boolean{
        return attempts == kittens.size
    }

    fun pickKitten(): Kittens{
        val kitten = kittens[index]
        return kitten
    }
}