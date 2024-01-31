package com.example.rumyuniquenicknameappname

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class HeaderMoviesHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textHead = itemView.findViewById<TextView>(R.id.titleText).apply {
        text = context.getString(R.string.movies_title)
    }
    private var markHead = itemView.findViewById<ImageView>(R.id.titleImage).apply {
        setImageResource(R.drawable.target)
    }
}