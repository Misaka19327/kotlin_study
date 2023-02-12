package com.example.commoncomposabletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.commoncomposabletest.ui.theme.CommonComposableTestTheme

class ButtonComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommonComposableTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Row(modifier = Modifier.size(100.dp)) {
                        FABTest()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview2() {
    CommonComposableTestTheme {
        Greeting2("Android")
    }
}

@Composable
fun ButtonTest() {
    Button(onClick = { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Done,
            contentDescription = null,
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(modifier = Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = "确认")
    }
}

@Composable
fun InteractionSourceTest() {
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val pressState = interactionSource.collectIsPressedAsState()
    val borderColor = if (pressState.value) Color.Green else Color.White
    
    Button(
        onClick = { /*TODO*/ },
        border = BorderStroke(2.dp, color = borderColor),
        interactionSource = interactionSource
    ) {
        Text(text = "长按")
    }
}

@Composable
fun IconButtonTest() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun FABTest() {
    Row {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
        }
        ExtendedFloatingActionButton(icon = {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = null
            ) },
            text = { Text(text = "示例")}, onClick = { /*TODO*/ })
    }
}
