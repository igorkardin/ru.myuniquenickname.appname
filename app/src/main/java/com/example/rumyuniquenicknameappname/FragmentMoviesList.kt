package com.example.rumyuniquenicknameappname

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentMoviesList : Fragment() {

    private var changeFragmentClickListener: ChangeFragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)

        view.findViewById<FrameLayout>(R.id.recycler)?.apply {
            setOnClickListener {
                changeFragmentClickListener?.changeFragment()
            }
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recycler = view.findViewById<RecyclerView>(R.id.recycler)
        val adapter = MovieAdapter()
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(requireContext(), 2)
        adapter.setItems(moviesList)
    }

    companion object {
        fun newInstance(key: String): FragmentMoviesList {
            val args = Bundle()
            args.putString("value", key)
            val fragment = FragmentMoviesList()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ChangeFragmentClickListener){
            changeFragmentClickListener = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        changeFragmentClickListener = null
    }

}

