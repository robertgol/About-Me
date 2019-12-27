package com.example.aboutme

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName = MyName("Robert Golusinski")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName
        binding.doneButton.setOnClickListener {
            addNickname()
            it.hide()
            hideKeyboard(it)
        }
    }

    private fun hideKeyboard(it: View) {
        getSystemService<InputMethodManager>()?.hideSoftInputFromWindow(it.windowToken, 0)
    }

    private fun addNickname() {
        with(binding) {
            myName?.nickname = nicknameEditText.text.toString()
            invalidateAll()
            nicknameEditText.hide()
            nicknameTextView.show()
        }
    }

    private fun View.hide() {
        visibility = View.GONE
    }

    private fun View.show() {
        visibility = View.VISIBLE
    }
}
