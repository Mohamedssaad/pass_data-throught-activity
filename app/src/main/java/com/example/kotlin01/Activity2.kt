package com.example.kotlin01

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class Activity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    private lateinit var btn_back: Button
    private lateinit var textPhone:TextView
    private lateinit var textmessage: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)

        btn_back=findViewById(R.id.btn_back)
        textPhone=findViewById(R.id.textPhone)
        textmessage=findViewById(R.id.textmessage)

        val incomingIntent= intent
        val mobile=incomingIntent.getStringExtra("Mobile")
        val message=incomingIntent.getStringExtra("message")
        textPhone.setText(mobile)
        textmessage.setText(message)


        btn_back.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
            finish();
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }




    }


}