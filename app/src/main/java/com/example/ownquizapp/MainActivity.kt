package com.example.ownquizapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private var selected: Int? = null
    var right: Int = 0
    private lateinit var tvQuestion: TextView
    private lateinit var tvOption1: TextView
    private lateinit var tvOption2: TextView
    private lateinit var tvOption3: TextView
    private lateinit var tvOption4: TextView
    private lateinit var tvOption5: TextView
    private lateinit var btnSelect: Button
    var turn = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvQuestion = findViewById(R.id.tvQuestion)
        tvOption1 = findViewById(R.id.tvOption1)
        tvOption2 = findViewById(R.id.tvOption2)
        tvOption3 = findViewById(R.id.tvOption3)
        tvOption4 = findViewById(R.id.tvOption4)
        tvOption5 = findViewById(R.id.tvOption5)
        btnSelect = findViewById(R.id.btnSelect)

        tvOption1.setOnClickListener {
            selected = 1
            tvOption1.setBackgroundResource(R.drawable.tv_selected_border)
            tvOption2.setBackgroundResource(R.drawable.tv_border)
            tvOption3.setBackgroundResource(R.drawable.tv_border)
            tvOption4.setBackgroundResource(R.drawable.tv_border)
            tvOption5.setBackgroundResource(R.drawable.tv_border)
        }
        tvOption2.setOnClickListener {
            selected = 2
            tvOption1.setBackgroundResource(R.drawable.tv_border)
            tvOption2.setBackgroundResource(R.drawable.tv_selected_border)
            tvOption3.setBackgroundResource(R.drawable.tv_border)
            tvOption4.setBackgroundResource(R.drawable.tv_border)
            tvOption5.setBackgroundResource(R.drawable.tv_border)
        }
        tvOption3.setOnClickListener {
            selected = 3
            tvOption1.setBackgroundResource(R.drawable.tv_border)
            tvOption2.setBackgroundResource(R.drawable.tv_border)
            tvOption3.setBackgroundResource(R.drawable.tv_selected_border)
            tvOption4.setBackgroundResource(R.drawable.tv_border)
            tvOption5.setBackgroundResource(R.drawable.tv_border)
        }
        tvOption4.setOnClickListener {
            selected = 4
            tvOption1.setBackgroundResource(R.drawable.tv_border)
            tvOption2.setBackgroundResource(R.drawable.tv_border)
            tvOption3.setBackgroundResource(R.drawable.tv_border)
            tvOption4.setBackgroundResource(R.drawable.tv_selected_border)
            tvOption5.setBackgroundResource(R.drawable.tv_border)
        }
        tvOption5.setOnClickListener {
            selected = 5
            tvOption1.setBackgroundResource(R.drawable.tv_border)
            tvOption2.setBackgroundResource(R.drawable.tv_border)
            tvOption3.setBackgroundResource(R.drawable.tv_border)
            tvOption4.setBackgroundResource(R.drawable.tv_border)
            tvOption5.setBackgroundResource(R.drawable.tv_selected_border)
        }

        btnSelect.setOnClickListener { entered() }

    }

    private fun entered() {
        var questionList: ArrayList<questionAndAnswers> = setQAndA.getQuestions()
        if (turn < questionList.size - 1)
            turn++
        else {
            btnSelect.isClickable = false
            btnSelect.setBackgroundColor(0)
            btnSelect.text="$right / 5 correct!"
        }

        if (turn == 0)
            btnSelect.text = "Select"

        tvQuestion.text = questionList[turn].question
        tvOption1.text = questionList[turn].option1
        tvOption2.text = questionList[turn].option2
        tvOption3.text = questionList[turn].option3
        tvOption4.text = questionList[turn].option4
        tvOption5.text = questionList[turn].option5

        tvOption1.setBackgroundResource(R.drawable.tv_border)
        tvOption2.setBackgroundResource(R.drawable.tv_border)
        tvOption3.setBackgroundResource(R.drawable.tv_border)
        tvOption4.setBackgroundResource(R.drawable.tv_border)
        tvOption5.setBackgroundResource(R.drawable.tv_border)
        var rightAns: Int? = null
        if (turn > 0) {
            rightAns = questionList[turn - 1].answer

            if (selected == rightAns) {
                Toast.makeText(this, "$selected is correct!", Toast.LENGTH_SHORT).show()
                right++
            } else
                Toast.makeText(
                    this,
                    "$selected is incorrect, the answer is : ${rightAns}!",
                    Toast.LENGTH_SHORT
                ).show()
        }
    }
}