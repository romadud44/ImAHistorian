package com.example.imahistorian

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imahistorian.databinding.ActivityThirdQuestionBinding

class ThirdQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityThirdQuestionBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.thirdQuestionTV.text = QuestionsAndAnswers().thirdQuestion
        binding.firstAnswerRB.text = QuestionsAndAnswers().firstAnswerForThirdQuestion
        binding.secondAnswerRB.text = QuestionsAndAnswers().secondAnswerForThirdQuestion
        binding.thirdAnswerRB.text = QuestionsAndAnswers().thirdAnswerForThirdQuestion
        val intentFourth = Intent(this, FourthQuestionActivity::class.java)
        binding.thirdAnswersGroupRG.setOnCheckedChangeListener { group, checkedID ->
            val result = intent.getStringExtra("2")
            val radio: RadioButton = findViewById(checkedID)
            when (radio) {
                binding.firstAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentFourth.putExtra("3", (0 + result!!.toInt()).toString())
                    startActivity(intentFourth)
                }

                binding.secondAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 0 баллов :(", Toast.LENGTH_LONG).show()
                    intentFourth.putExtra("3", (0 + result!!.toInt()).toString())
                    startActivity(intentFourth)
                }

                binding.thirdAnswerRB -> {
                    Toast.makeText(this, "Вы заработали 100 баллов :)", Toast.LENGTH_LONG).show()
                    intentFourth.putExtra("3", (100 + result!!.toInt()).toString())
                    startActivity(intentFourth)
                }
            }
        }


        binding.toolbarThirdQuestion.title = "Третий вопрос"
        //binding.toolbarFirstQuestion.subtitle =
        setSupportActionBar(binding.toolbarThirdQuestion)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}