package com.poooootiful.mobilt_java23_johanna_pettersson_lifecycle_v4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class Page2 :AppCompatActivity(){
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
        val text = findViewById<TextView>(R.id.infotext2)

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

        text.setText("Info saved/Changed")
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
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.page2)

        val loginpage:Button = findViewById<Button>(R.id.loginpage)
        val save:Button = findViewById<Button>(R.id.save)
        val text = findViewById<TextView>(R.id.infotext2)

        save.setOnClickListener(View.OnClickListener {
            save()
        })

        loginpage.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            startActivity(intent)

        })


    }

}