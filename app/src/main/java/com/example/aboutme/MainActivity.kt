package com.example.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.doneButton).setOnClickListener {
            addNickname()
            it.hide()
            hideKeyboard(it)
        }
    }

    private fun hideKeyboard(it: View) {
        getSystemService<InputMethodManager>()?.hideSoftInputFromWindow(it.windowToken, 0)
    }

    private fun addNickname() {
        val editText = findViewById<EditText>(R.id.nicknameEditText)
        val nicknameTextView = findViewById<TextView>(R.id.nicknameTextView)

        nicknameTextView.text = editText.text
        editText.hide()
        nicknameTextView.visibility = View.VISIBLE
    }

    private fun View.hide() {
        visibility = View.GONE
    }
}
