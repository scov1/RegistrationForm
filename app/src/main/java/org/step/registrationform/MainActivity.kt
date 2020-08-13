package org.step.registrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.registration.*
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {

    lateinit var username:EditText
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var passwordTwo:EditText
    lateinit var btnGet:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        printHome()

        btn_reg.setOnClickListener{
            registrationUser()
        }

        btnGet = findViewById(R.id.btn_get)
        username=findViewById(R.id.username)
        email=findViewById(R.id.email)
        password=findViewById(R.id.password)
        passwordTwo=findViewById(R.id.password_two)



        btnGet.setOnClickListener{

            val txt = "Error!!!"
            val txt2="Done!Success!"
            val dur = Toast.LENGTH_LONG

            if(username.text.isEmpty() ||  email.text.isEmpty() || password.text.isEmpty() || passwordTwo.text.isEmpty() || !Pattern.compile("[0-9]").matcher(username.text).find() || !Pattern.compile("[a-zA-Z]").matcher(username.text).find()){
                val toast = Toast.makeText(applicationContext,txt,dur).show()
            }else if(password!!.text.toString() != passwordTwo!!.text.toString()){
                val toast = Toast.makeText(applicationContext,txt,dur).show()
            }else{
                val toast= Toast.makeText(applicationContext,txt2,dur).show()
            }
        }

    }

    private fun registrationUser(){
        reg_layout.visibility= View.VISIBLE
        home.visibility=View.GONE
    }

    private fun printHome(){
        reg_layout.visibility=View.GONE
        home.visibility=View.VISIBLE
    }
}