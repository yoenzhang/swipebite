package com.example.swipebyte.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.swipebyte.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Add dynamic content programmatically
        val dynamicContainer: LinearLayout = binding.dynamicContainer

        // Add a restaurant card to the container
        addRestaurantCard(
            dynamicContainer,
            "Lazeez Shawarma",
            "Middle Eastern - $$$$",
            "2.6 ★ (1,000+)",
            "1.5 km away",
            "https://via.placeholder.com/600x400.png?text=Restaurant+Image" // Placeholder image
        )

        return root
    }

    private fun addRestaurantCard(
        container: LinearLayout,
        name: String,
        cuisine: String,
        rating: String,
        distance: String,
        imageUrl: String
    ) {
        // Card layout
        val cardLayout = LinearLayout(requireContext()).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 0, 0, 16)
            }
            setPadding(16)
            setBackgroundResource(android.R.drawable.dialog_holo_light_frame)
        }

        // ImageView
        val imageView = ImageView(requireContext()).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                400 // Fixed height for the image
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        Glide.with(this).load(imageUrl).into(imageView)
        cardLayout.addView(imageView)

        // Texts (Name, Cuisine, Rating, Distance)
        val nameTextView = TextView(requireContext()).apply {
            text = name
            textSize = 20f
            setPadding(8)
        }
        cardLayout.addView(nameTextView)

        val cuisineTextView = TextView(requireContext()).apply {
            text = cuisine
            textSize = 16f
            setPadding(8)
        }
        cardLayout.addView(cuisineTextView)

        val ratingTextView = TextView(requireContext()).apply {
            text = rating
            textSize = 14f
            setPadding(8)
        }
        cardLayout.addView(ratingTextView)

        val distanceTextView = TextView(requireContext()).apply {
            text = distance
            textSize = 14f
            setPadding(8)
        }
        cardLayout.addView(distanceTextView)

        // Add card to the container
        container.addView(cardLayout)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
