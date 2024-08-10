package com.example.imahistorian

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.imahistorian.databinding.ActivityFifthQuestionBinding
import com.example.imahistorian.databinding.ActivityResultBinding
import javax.security.auth.login.LoginException

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityResultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.toolbarResult.title = "Результат"
        //binding.toolbarFirstQuestion.subtitle =
        setSupportActionBar(binding.toolbarResult)

        val result = intent.getStringExtra("5")
        binding.resultTV.text = "$result"

        when (result) {
            "500" -> {
                binding.resultTV.setTextColor(Color.GREEN)
                binding.resultCommentTV.text = QuestionsAndAnswers().resultComment[5]
                binding.resultInfoTV.text = QuestionsAndAnswers().resultInfo[5]
            }

            "400" -> {
                binding.resultTV.setTextColor(Color.BLUE)
                binding.resultCommentTV.text = QuestionsAndAnswers().resultComment[4]
                binding.resultInfoTV.text = QuestionsAndAnswers().resultInfo[4]
            }

            "300" -> {
                binding.resultTV.setTextColor(Color.YELLOW)
                binding.resultCommentTV.text = QuestionsAndAnswers().resultComment[3]
                binding.resultInfoTV.text = QuestionsAndAnswers().resultInfo[3]
            }

            "200" -> {
                binding.resultTV.setTextColor(Color.YELLOW)
                binding.resultCommentTV.text = QuestionsAndAnswers().resultComment[2]
                binding.resultInfoTV.text = QuestionsAndAnswers().resultInfo[2]
            }

            "100" -> {
                binding.resultTV.setTextColor(Color.BLACK)
                binding.resultCommentTV.text = QuestionsAndAnswers().resultComment[1]
                binding.resultInfoTV.text = QuestionsAndAnswers().resultInfo[1]
            }

            "0" -> {
                binding.resultTV.setTextColor(Color.RED)
                binding.resultCommentTV.text = QuestionsAndAnswers().resultComment[0]
                binding.resultInfoTV.text = QuestionsAndAnswers().resultInfo[0]
            }
        }

        binding.restartBTN.setOnClickListener {
            val intentRestart = Intent(this, MainActivity::class.java)
            startActivity(intentRestart)
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}