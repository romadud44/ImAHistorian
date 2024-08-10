package com.example.imahistorian

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imahistorian.databinding.ActivitySecondQuestionBinding

class SecondQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivitySecondQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarSecondQuestion.title = "Второй вопрос"
        setSupportActionBar(binding.toolbarSecondQuestion)

        binding.secondQuestionTV.text = QuestionsAndAnswers().questions[2]
        binding.firstAnswerRB.text = QuestionsAndAnswers().answers[2_1]
        binding.secondAnswerRB.text = QuestionsAndAnswers().answers[2_2]
        binding.thirdAnswerRB.text = QuestionsAndAnswers().answers[2_3]
        val intentThird = Intent(this, ThirdQuestionActivity::class.java)
        binding.secondAnswersGroupRG.setOnCheckedChangeListener { group, checkedID ->
            val result = intent.getStringExtra("1")
            val radio: RadioButton = findViewById(checkedID)
            when (radio) {
                binding.firstAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentThird.putExtra("2", (0 + result!!.toInt()).toString())
                    startActivity(intentThird)
                }

                binding.secondAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 100 баллов :)", Toast.LENGTH_LONG).show()
                    intentThird.putExtra("2", (100 + result!!.toInt()).toString())
                    startActivity(intentThird)
                }

                binding.thirdAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentThird.putExtra("2", (0 + result!!.toInt()).toString())
                    startActivity(intentThird)
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