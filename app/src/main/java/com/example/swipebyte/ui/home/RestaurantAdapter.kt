package com.example.swipebyte.ui.home

import android.view.Gravity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RestaurantAdapter(private val restaurantList: List<Restaurant>) :
    RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    class RestaurantViewHolder(val layout: LinearLayout) : RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val layout = LinearLayout(parent.context).apply {
            orientation = LinearLayout.VERTICAL
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
            )
            gravity = Gravity.CENTER
            setPadding(24)
        }
        return RestaurantViewHolder(layout)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurantList[position]

        // Clear any previous views
        holder.layout.removeAllViews()

        // Image View
        val imageView = ImageView(holder.layout.context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                600
            )
            scaleType = ImageView.ScaleType.CENTER_CROP
        }
        Glide.with(holder.layout.context).load(restaurant.imageUrl).into(imageView)
        holder.layout.addView(imageView)

        // Restaurant Name
        val nameTextView = TextView(holder.layout.context).apply {
            text = restaurant.name
            textSize = 24f
            gravity = Gravity.CENTER
            setPadding(16)
        }
        holder.layout.addView(nameTextView)

        // Cuisine
        val cuisineTextView = TextView(holder.layout.context).apply {
            text = restaurant.cuisine
            textSize = 18f
            gravity = Gravity.CENTER
            setPadding(8)
        }
        holder.layout.addView(cuisineTextView)

        // Rating
        val ratingTextView = TextView(holder.layout.context).apply {
            text = restaurant.rating
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(8)
        }
        holder.layout.addView(ratingTextView)

        // Distance
        val distanceTextView = TextView(holder.layout.context).apply {
            text = restaurant.distance
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(8)
        }
        holder.layout.addView(distanceTextView)
    }

    override fun getItemCount(): Int = restaurantList.size
}
