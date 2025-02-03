package com.example.swipebyte.ui.communityFavourites

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.swipebyte.R

class CommunityFavourites : Fragment() {

    companion object {
        fun newInstance() = CommunityFavourites()
    }

    private val viewModel: CommunityFavouritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_community_favourites, container, false)

        // Set up navigation for the button
        view.findViewById<View>(R.id.buttonToOtherPage).setOnClickListener {
            findNavController().navigate(R.id.navigation_home) // Replace with the desired destination
        }

        return view
    }
}
