package com.example.rumyuniquenicknameappname

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class MovieAdapter : RecyclerView.Adapter<ViewHolder>() {

    private val moviesList = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TYPE_MOVIE -> MovieViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.view_holder_movie, parent, false)
            )
            TYPE_HEADER -> HeaderMoviesHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.list_header, parent, false)
            )
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is MovieViewHolder -> holder.bind(moviesList[position])
        }
    }


    override fun getItemCount(): Int {
        return moviesList.size + 1
    }

    fun setItems(newItems: List<Movie>) {
        moviesList.addAll(newItems)
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            else -> TYPE_MOVIE
        }
    }
}

const val TYPE_HEADER = 0
const val TYPE_MOVIE = 1