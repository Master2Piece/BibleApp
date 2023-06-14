package com.example.bibleapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BibleListAdapter : RecyclerView.Adapter<BibleListAdapter.ViewHolder>() {
    private var bibleList = mutableListOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bible, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val book = bibleList[position]
        holder.bind(book)
    }

    override fun getItemCount(): Int {
        return bibleList.size
    }

    fun setData(data: List<String>) {
        bibleList.clear()
        bibleList.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun bind(book: String) {
            textView.text = book
        }
    }
}