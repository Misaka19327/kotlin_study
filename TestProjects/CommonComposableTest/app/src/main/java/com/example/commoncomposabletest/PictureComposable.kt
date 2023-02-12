package com.example.commoncomposabletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.commoncomposabletest.ui.theme.CommonComposableTestTheme

class PictureComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommonComposableTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun IconTest() {
    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null, tint = Color.Red)
}

@Composable
fun ImageTest() {
    Image(painter = painterResource(
        id = R.drawable.pic_1),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        colorFilter = ColorFilter.lighting(Color.Red, Color.Green),
        modifier = Modifier.size(height = 40.dp, width = 80.dp)
    )
}