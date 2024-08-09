package com.example.imahistorian

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imahistorian.databinding.ActivityFourthQuestionBinding

class FourthQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFourthQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityFourthQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.fourthQuestionTV.text = QuestionsAndAnswers().fourthQuestion
        binding.firstAnswerRB.text = QuestionsAndAnswers().firstAnswerForFourthQuestion
        binding.secondAnswerRB.text = QuestionsAndAnswers().secondAnswerForFourthQuestion
        binding.thirdAnswerRB.text = QuestionsAndAnswers().thirdAnswerForFourthQuestion
        val intentFifth = Intent(this, FifthQuestionActivity::class.java)
        binding.fourthAnswersGroupRG.setOnCheckedChangeListener { group, checkedID ->
            val result = intent.getStringExtra("3")
            val radio: RadioButton = findViewById(checkedID)
            when (radio) {
                binding.firstAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 100 баллов :)", Toast.LENGTH_LONG).show()
                    intentFifth.putExtra("4", (100 + result!!.toInt()).toString())
                    startActivity(intentFifth)
                }

                binding.secondAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentFifth.putExtra("4", (0 + result!!.toInt()).toString())
                    startActivity(intentFifth)
                }

                binding.thirdAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentFifth.putExtra("4", (0 + result!!.toInt()).toString())
                    startActivity(intentFifth)
                }
            }
        }

        binding.toolbarFourthQuestion.title = "Четвертый вопрос"
        //binding.toolbarFirstQuestion.subtitle =
        setSupportActionBar(binding.toolbarFourthQuestion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}