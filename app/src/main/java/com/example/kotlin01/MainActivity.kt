package com.example.kotlin01

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "SetTextI18n")

    lateinit var btn_next:Button
    lateinit var btn_close:Button
    lateinit var edtPhone:EditText
    lateinit var edtmessage:EditText




    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // layout inflation  بتجيب ال xml

        btn_next=findViewById(R.id.btn_next)
        btn_close=findViewById(R.id.btn_close)
        edtPhone=findViewById(R.id.edtPhone)
        edtmessage=findViewById(R.id.edtmessage)


        //register event Listener
        //lambda
        btn_next.setOnClickListener {

            //context , destination activity or service or broadcast resiver
            val intent=Intent(this,Activity2::class.java)
            intent.putExtra("Mobile",edtPhone.text.toString())
            intent.putExtra("message",edtmessage.text.toString())
            startActivity(intent)
        }
        btn_close.setOnClickListener { finish() }



    }


}