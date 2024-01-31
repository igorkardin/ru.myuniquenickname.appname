package com.example.rumyuniquenicknameappname

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), ChangeFragmentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, FragmentMoviesList.newInstance("fragment"))
                .commit()
        }
    }

    override fun changeFragment() {
        findViewById<FrameLayout>(R.id.frame_layout)
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, FragmentMoviesDetails())
            .addToBackStack(null)
            .commit()
    }

}
