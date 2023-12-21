package com.example.a9

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var rndbtn: Button
    private lateinit var more: Button
    private lateinit var less: Button
    private lateinit var nextact: Button
    private lateinit var fromtxt: EditText
    private lateinit var totxt: EditText
    private lateinit var numb: TextView
    var rndnum = 0
    var from = 0
    var to = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rndbtn = findViewById(R.id.button)
        more = findViewById(R.id.more)
        less = findViewById(R.id.less)
        numb = findViewById(R.id.numb)
        fromtxt = findViewById(R.id.from)
        totxt = findViewById(R.id.to)
        nextact = findViewById(R.id.nextact)

        nextact.setOnClickListener {
            val randomIntent = Intent(this, MainActivity2::class.java)
            startActivity(randomIntent)
        }

        rndbtn.setOnClickListener {
            from = fromtxt.text.toString().toInt()
            to = totxt.text.toString().toInt()
            rndnum = (from..to).random()
            numb.text = rndnum.toString()
            more.setTransitionVisibility(View.VISIBLE)
            less.setTransitionVisibility(View.VISIBLE)
        }

        more.setOnClickListener {
            from = rndnum
            rndnum = (from..to).random()
            numb.text = rndnum.toString()
        }

        less.setOnClickListener {
            to = rndnum
            rndnum = (from..to).random()
            numb.text = rndnum.toString()
        }
    }
}