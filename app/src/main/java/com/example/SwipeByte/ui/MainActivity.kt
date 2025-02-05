package com.example.swipebyte

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.swipebyte.navigation.AppNavigation
import com.example.SwipeByte.ui.theme.SwipeByteTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeByteTheme { // ✅ Now correctly references the theme
                AppNavigation()
            }
        }
    }
}
