package com.example.tms_an_15_homework_lesson_18


import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import java.util.Locale

class DataEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_entry)

        val button = findViewById<Button>(R.id.enterButton)
        val loginText = findViewById<EditText>(R.id.username)
        val passwordText = findViewById<EditText>(R.id.password)


        button.setOnClickListener {
            val checkButtonIndex = findViewById<RadioGroup>(R.id.radioGroup).checkedRadioButtonId

            if (loginText.text.length < 6) {
                button.setBackgroundColor(Color.RED)
                loginText.error = "Username Required"
                return@setOnClickListener
            } else if (passwordText.text.length < 6) {
                button.setBackgroundColor(Color.RED)
                passwordText.error = "Password Required"
                return@setOnClickListener
            } else {
                when (checkButtonIndex) {
                    R.id.radioButton1 -> {
                        setLocale(this, "en")
                        recreate()
                    }
                    R.id.radioButton2 -> {
                        setLocale(this, "ru")
                        recreate()
                    }
                }

                val intent = Intent(this, UserDataActivity::class.java)
                intent.putExtra("login", loginText.text.toString())
                intent.putExtra("password", passwordText.text.toString())

                intent.putExtra("checkBox1", findViewById<CheckBox>(R.id.checkBox1).isChecked)
                intent.putExtra("checkBox2", findViewById<CheckBox>(R.id.checkBox2).isChecked)
                intent.putExtra("checkBox3", findViewById<CheckBox>(R.id.checkBox3).isChecked)

                startActivity(intent)
            }
        }
    }

    fun setLocale(context: Context, languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        context.createConfigurationContext(configuration)
    }
}





