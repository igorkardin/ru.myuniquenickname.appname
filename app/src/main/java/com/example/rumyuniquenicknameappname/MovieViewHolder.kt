package com.example.rumyuniquenicknameappname

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private var limit: TextView = itemView.findViewById(R.id.avengers_age_limit_13)
    private val poster: ImageView = itemView.findViewById(R.id.avengers)
    private val title: TextView = itemView.findViewById(R.id.avengers_name)
    private val genre: TextView = itemView.findViewById(R.id.avengers_genre)

    private val star1: ImageView = itemView.findViewById(R.id.avengers_star1)
    private val star2: ImageView = itemView.findViewById(R.id.avengers_star2)
    private val star3: ImageView = itemView.findViewById(R.id.avengers_star3)
    private val star4: ImageView = itemView.findViewById(R.id.avengers_star4)
    private val star5: ImageView = itemView.findViewById(R.id.avengers_star5)
    private val stars = listOf(star1, star2, star3, star4, star5)

    private val reviews: TextView = itemView.findViewById(R.id.avengers_reviews)
    private val duration: TextView = itemView.findViewById(R.id.avengers_duration)
    private val like: ImageView = itemView.findViewById(R.id.avengers_like)

    fun bind(movie: Movie) {
        limit.text = movie.limit
        title.text = movie.title
        genre.text = movie.genre
        reviews.text = movie.reviews
        duration.text = movie.duration

        val colorRed = ContextCompat.getColor(itemView.context, R.color.red)
        val colorWhite = ContextCompat.getColor(itemView.context, R.color.white)
        val colorGray = ContextCompat.getColor(itemView.context, R.color.gray)

        if (movie.like) {
            like.setColorFilter(colorRed)
        } else {
            like.setColorFilter(colorWhite)
        }

        stars.forEachIndexed { index, imageView ->
            if (index < movie.stars) {
                imageView.setColorFilter(colorRed)
            } else {
                imageView.setColorFilter(colorGray)
            }
        }

        Picasso.get()
            .load(movie.poster)
            .fit()
            .placeholder(R.drawable.avengers)
            .into(poster)

    }
}