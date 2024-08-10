package com.example.imahistorian

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imahistorian.databinding.ActivityFifthQuestionBinding

class FifthQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFifthQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFifthQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fifthQuestionTV.text = QuestionsAndAnswers().questions[5]
        binding.firstAnswerRB.text = QuestionsAndAnswers().answers[5_1]
        binding.secondAnswerRB.text = QuestionsAndAnswers().answers[5_2]
        binding.thirdAnswerRB.text = QuestionsAndAnswers().answers[5_3]
        val intentResult = Intent(this, ResultActivity::class.java)
        binding.fifthAnswersGroupRG.setOnCheckedChangeListener { group, checkedID ->
            val result = intent.getStringExtra("4")
            val radio: RadioButton = findViewById(checkedID)
            when (radio) {
                binding.firstAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentResult.putExtra("5", (0 + result!!.toInt()).toString())
                    startActivity(intentResult)
                }

                binding.secondAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 100 баллов :)", Toast.LENGTH_LONG).show()
                    intentResult.putExtra("5", (100 + result!!.toInt()).toString())
                    startActivity(intentResult)
                }

                binding.thirdAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentResult.putExtra("5", (0 + result!!.toInt()).toString())
                    startActivity(intentResult)
                }
            }
        }

        binding.toolbarFifthQuestion.title = "Пятый вопрос"
        //binding.toolbarFirstQuestion.subtitle =
        setSupportActionBar(binding.toolbarFifthQuestion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}