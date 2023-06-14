package com.example.bibleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bibleapp.ui.theme.BibleAppTheme

import android.content.Intent
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDailyVerses = findViewById<Button>(R.id.btnDailyVerses)
        val btnBible = findViewById<Button>(R.id.btnBible)

        btnDailyVerses.setOnClickListener {
            navigateToDailyVerses()
        }

        btnBible.setOnClickListener {
            navigateToBibleList()
        }
    }

    private fun navigateToDailyVerses() {
        val intent = Intent(this, DailyVersesActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToBibleList() {
        val intent = Intent(this, BibleListActivity::class.java)
        startActivity(intent)
    }
}