package com.poooootiful.mobilt_java23_johanna_pettersson_lifecycle_v4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val defaultUsername = "user"
        val defaultPassword = "pass1"

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginbtn:Button = findViewById<Button>(R.id.login)
        val logoutbtn:Button = findViewById<Button>(R.id.logout)
        val page:Button = findViewById<Button>(R.id.page)

        loginbtn.setOnClickListener(View.OnClickListener {

            val user = username.text.toString()
            val pass = password.text.toString()

            Log.d("user",user)
            Log.d("pass",pass)
            Log.d("user",defaultUsername)
            Log.d("pass",defaultPassword)

            val test = "hrllo"

          if (user==defaultUsername && pass==defaultPassword) {
                Log.d("test",test)
                startActivity(Intent(this.baseContext, Page2::class.java))
           }
        })
    }
}