package com.example.a9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.text.isDigitsOnly

class MainActivity2 : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var btnrefresh: Button
    private lateinit var backbtn: Button
    private lateinit var edittxt: EditText
    private lateinit var numb: TextView
    var from = (0..999).random()
    var to = (from..999).random()
    var rndnum = (from..to).random()
    var fl = true


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn = findViewById(R.id.button2)
        btnrefresh = findViewById(R.id.button3)
        backbtn = findViewById(R.id.button4)
        edittxt = findViewById(R.id.editTextText)
        numb = findViewById(R.id.textView2)

        numb.text = "Угадайте случайно число в дипазоне от $from до $to"

        btn.setOnClickListener {
            if(fl) {
                if (edittxt.text.isDigitsOnly() && edittxt.text.toString().toInt() == rndnum) {
                    edittxt.text.clear()
                    btn.text = "Начать сначала"
                    numb.text = "Правильно! Загаданное число - $rndnum"
                    fl = false
                } else {
                    if(edittxt.text.toString().toInt() > rndnum && edittxt.text.toString().toInt() < to){
                        to = edittxt.text.toString().toInt()
                        numb.text = "Неправильно! Число меньше ($from .. $to)"
                    } else if(edittxt.text.toString().toInt() > rndnum && edittxt.text.toString().toInt() > to) {
                        numb.text = "Неправильно! Число меньше ($from .. $to)"
                    } else if (edittxt.text.toString().toInt() < rndnum && edittxt.text.toString().toInt() > from ) {
                        from = edittxt.text.toString().toInt()
                        numb.text = "Неправильно! Число больше ($from .. $to)"
                    } else if (edittxt.text.toString().toInt() < rndnum && edittxt.text.toString().toInt() < from) {
                        numb.text = "Неправильно! Число больше ($from .. $to)"
                    }
                }
            } else {
                from = (0..999).random()
                to = (from..999).random()
                rndnum = (from..to).random()
                numb.text = "Угадайте случайно число в дипазоне от $from до $to"
                btn.text = "Попытка"
                fl = true
            }
        }

        btnrefresh.setOnClickListener {
            from = (0..999).random()
            to = (from..999).random()
            rndnum = (from..to).random()
            numb.text = "Угадайте случайно число в дипазоне от $from до $to"
        }

        backbtn.setOnClickListener {
            val randomIntent = Intent(this, MainActivity::class.java)
            startActivity(randomIntent)
        }
    }
}