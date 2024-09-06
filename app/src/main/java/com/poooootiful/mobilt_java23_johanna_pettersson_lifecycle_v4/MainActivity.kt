package com.poooootiful.mobilt_java23_johanna_pettersson_lifecycle_v4

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        val defaultusername:String = "user"
        val defaultpasssword:String = "pass1"

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val loginbtn:Button = findViewById<Button>(R.id.login)
        var infotext = findViewById<TextView>(R.id.infotext)
        val logoutbtn:Button = findViewById<Button>(R.id.logout)
        val page:Button = findViewById<Button>(R.id.page)

        loginbtn.setOnClickListener(View.OnClickListener {
            val user = username.text.toString()
            val pass = password.text.toString()

            Log.d("user",user)
            Log.d("pass",pass)
            Log.d("user", defaultusername)
            Log.d("pass",defaultpasssword)

            if (user.equals(defaultusername) && pass.equals(defaultpasssword)) {
                val intent = Intent (this, Page2::class.java)
                startActivity(intent)

                infotext.setText("You are logged in")

                page.setOnClickListener(View.OnClickListener {
                    val intent = Intent (this, Page2::class.java)
                    startActivity(intent)
                })
            }
        })

        logoutbtn.setOnClickListener(View.OnClickListener {
            infotext.setText("You are logged out")
        })

    }
}