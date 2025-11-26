package com.example.lab2

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        val questionField = findViewById<EditText>(R.id.user_question)
        val answerField = findViewById<EditText>(R.id.user_answer)
        val saveButton = findViewById<ImageView>(R.id.save_button)
        val cancelButton = findViewById<ImageView>(R.id.cancel_button)
       cancelButton.setOnClickListener {
           setResult(RESULT_CANCELED)
           finish()

       }
        saveButton.setOnClickListener {
            val question = questionField.text.toString()
            val answer = answerField.text.toString()
            val data =
                Intent() // create a new Intent, this is where we will put our data

            data.putExtra(
                "quetion_key",
                "amswer_key"
            ) // puts one string into the Intent, with the key as 'string1'

            data.putExtra(
                "smwer_key",
                "user_answer"
            ) // puts another string into the Intent, with the key as 'string2

            setResult(RESULT_OK, data) // set result code and bundle data for response

            finish()
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}