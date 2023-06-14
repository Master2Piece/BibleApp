package com.example.bibleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL

class BibleListActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: BibleListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bible_list)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = BibleListAdapter()
        recyclerView.adapter = adapter

        loadBibleList()
    }

    private fun loadBibleList() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val url = URL("https://api-alkitab.herokuapp.com/v2/passage/list")
                val response = url.readText()

                val json = JSONObject(response)
                val verses = json.getJSONArray("passages")

                val verseList = mutableListOf<String>()

                for (i in 0 until verses.length()) {
                    val verse = verses.getString(i)
                    verseList.add(verse)
                }

                withContext(Dispatchers.Main) {
                    adapter.setData(verseList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}