package com.example.imahistorian

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
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
        setSupportActionBar(binding.toolbarFirstQuestion)
        binding.firstQuestionTV.text = QuestionsAndAnswers().firstQuestion
        binding.firstAnswerRB.text = QuestionsAndAnswers().firstAnswerForFirstQuestion
        binding.secondAnswerRB.text = QuestionsAndAnswers().secondAnswerForFirstQuestion
        binding.thirdAnswerRB.text = QuestionsAndAnswers().thirdAnswerForFirstQuestion

        val intentSecond = Intent(this, SecondQuestionActivity::class.java)
        binding.firstAnswersGroupRG.setOnCheckedChangeListener { group, checkedID ->

            val radio: RadioButton = findViewById(checkedID)
            when (radio) {
                binding.firstAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentSecond.putExtra("1", (0).toString())
                    startActivity(intentSecond)
                }

                binding.secondAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentSecond.putExtra("1", (0).toString())
                    startActivity(intentSecond)
                }

                binding.thirdAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 100 баллов :)", Toast.LENGTH_LONG).show()
                    intentSecond.putExtra("1", (100).toString())
                    startActivity(intentSecond)
                }
            }
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}