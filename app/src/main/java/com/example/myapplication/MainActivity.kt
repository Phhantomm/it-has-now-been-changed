package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonReg.setOnClickListener {
            val email = emailAddress.text.toString()
            val password = textPassword.text.toString()
            if (email.isEmpty()||password.isEmpty()){
                Toast.makeText(applicationContext,"invalid", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Toast.makeText(this,"User Successfully Created", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Something went wrong", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}