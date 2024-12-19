package com.poooootiful.mobilt_java23_johanna_pettersson_lifecycle_v4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.prefs.Preferences

class Page2 :AppCompatActivity(){
    lateinit var sharedPreferences:android.content.SharedPreferences

    var savedpassword:String = ""
    var savedusername:String = ""
    var savedbirthday:String = ""
    var savedemail:String = ""
    var savephone:String = ""
    var camper:Boolean=false

    private fun save () {
        val password = findViewById <EditText>(R.id.changepassword).text
        val username = findViewById <EditText>(R.id.changeusername).text
        val birthday:Any = findViewById<EditText>(R.id.birthday).text
        val email:Any = findViewById<EditText>(R.id.email).text
        val phone:Any = findViewById<EditText>(R.id.phone).text
        val camping = findViewById<CheckBox>(R.id.beencamping)
        
        savedpassword = password.toString()
        savedusername = username.toString()
        savedbirthday = birthday.toString()
        savedemail = email.toString()
        savephone = phone.toString()

        if (camping.isChecked) {
            camper = true
        }else {
            camper = false
        }

        sharedPreferences.edit().putString("Username",savedusername).apply()
        sharedPreferences.edit().putString("Password", savedpassword).apply()
        sharedPreferences.edit().putString("Email",savedemail).apply()
        sharedPreferences.edit().putString("Birthday",savedbirthday).apply()
        sharedPreferences.edit().putString("PhoneNumber",savephone).apply()
        sharedPreferences.edit().putBoolean("IsCamper",camper).apply()

    }

    override fun onDestroy() {
        super.onDestroy()
        save()
    }

    override fun onStop() {
        super.onStop()
        save()
    }
    override fun onPause() {
        super.onPause()
        save()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.page2)

        val loginpage:Button = findViewById<Button>(R.id.loginpage)
        val save:Button = findViewById<Button>(R.id.save)

        val password = findViewById <EditText>(R.id.changepassword)
        val username = findViewById <EditText>(R.id.changeusername)
        val birthday = findViewById<EditText>(R.id.birthday)
        val email = findViewById<EditText>(R.id.email)
        val phone = findViewById<EditText>(R.id.phone)
        val camping = findViewById<CheckBox>(R.id.beencamping)

        password.setText(sharedPreferences.getString("Password",""))
        username.setText(sharedPreferences.getString("Username",""))
        birthday.setText(sharedPreferences.getString("birthday",""))
        email.setText(sharedPreferences.getString("Email",""))
        phone.setText(sharedPreferences.getString("PhoneNumber",""))


        save.setOnClickListener(View.OnClickListener {
            save()
        })

        loginpage.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)

        })
    }

}