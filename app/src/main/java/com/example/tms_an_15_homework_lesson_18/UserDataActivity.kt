package com.example.tms_an_15_homework_lesson_18

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class UserDataActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data)

        val receivedLoginText = intent.getStringExtra("login")
        val receivedPassText = intent.getStringExtra("password")

        val isChecked1 = intent.getBooleanExtra(CheckBoxKeys.CHECKBOX_1, false)
        val isChecked2 = intent.getBooleanExtra(CheckBoxKeys.CHECKBOX_2, false)
        val isChecked3 = intent.getBooleanExtra(CheckBoxKeys.CHECKBOX_3, false)

        if (!isChecked1) {
            findViewById<TextView>(R.id.checkBoxText1).isVisible = isChecked1
        }
        if (!isChecked2) {
            findViewById<TextView>(R.id.checkBoxText2).isVisible = isChecked2
        }
        if (!isChecked3) {
            findViewById<TextView>(R.id.checkBoxText3).isVisible = isChecked3
        }

        findViewById<TextView>(R.id.inputName_profile).text = "$receivedLoginText"
        findViewById<TextView>(R.id.inputPassword_profile).text = "$receivedPassText"

        findViewById<Button>(R.id.exitButton).setOnClickListener {

            val intent = Intent(this, DataEntryActivity::class.java)
            finish()
            startActivity(intent)
        }
    }
}
