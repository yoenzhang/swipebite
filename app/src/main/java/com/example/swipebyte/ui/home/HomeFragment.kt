package com.example.swipebyte.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.swipebyte.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val restaurantList = listOf(
            Restaurant("Lazeez Shawarma", "Middle Eastern - $$$$", "2.6 ★ (1,000+)", "1.5 km away",
                "https://d1ralsognjng37.cloudfront.net/83bb5d98-43b6-4b86-bb9e-4c4c89c11a33.jpeg"),
            Restaurant("Subway", "Fast Food - $$", "3.8 ★ (2,000+)", "800m away",
                "https://www.subway.com/ns/images/hero/Sandwich_Buffet.jpg"),
            Restaurant("McDonald's", "Burgers - $$", "4.1 ★ (5,000+)", "500m away",
                "https://www.mcdonalds.com/content/dam/sites/usa/nfl/publication/1PUB_106_McD_Top20WebsiteRefresh_Photos_QuarterPounderCheese.jpg"),
            Restaurant("Pizza Hut", "Italian - $$$", "4.0 ★ (3,500+)", "2.0 km away",
                "https://www.pizzahut.com/assets/w/tile/th-menu-icon.jpg")
        )

        val adapter = RestaurantAdapter(restaurantList)

        binding.viewPager.apply {
            this.adapter = adapter
            orientation = ViewPager2.ORIENTATION_VERTICAL // Enables vertical scrolling
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
