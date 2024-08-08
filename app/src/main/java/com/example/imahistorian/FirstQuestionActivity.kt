package com.example.imahistorian

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imahistorian.databinding.ActivityFirstQuestionBinding

class FirstQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFirstQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarFirstQuestion.title = "Первый вопрос"
        //binding.toolbarFirstQuestion.subtitle =
        setSupportActionBar(binding.toolbarFirstQuestion)
        binding.firstQuestionTV.text = QuestionsAndAnswers().firstQuestion
        binding.firstAnswerRB.text = QuestionsAndAnswers().firstAnswerForFirstQuestion
        binding.secondAnswerRB.text = QuestionsAndAnswers().secondAnswerForFirstQuestion
        binding.thirdAnswerRB.text = QuestionsAndAnswers().thirdAnswerForFirstQuestion


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}