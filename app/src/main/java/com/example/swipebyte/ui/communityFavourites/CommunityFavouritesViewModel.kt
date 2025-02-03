package com.example.swipebyte.ui.communityFavourites

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CommunityFavouritesViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is community favourites Fragment"
    }
    val text: LiveData<String> = _text
}