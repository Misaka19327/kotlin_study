package com.example.commoncomposabletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.commoncomposabletest.ui.theme.CommonComposableTestTheme

class ChooseComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommonComposableTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SliderTest()
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview3() {
    CommonComposableTestTheme {
        Greeting3("Android")
    }
}

@Composable
fun CheckboxTest() {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Checkbox(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it },
        colors = CheckboxDefaults.colors(checkedColor = Color(0xFF0079D3))
    )
}

@Composable
fun TriStateCheckboxTest() {
    // 先为两个子Checkbox定义状态
    val (state, onStateChange) = remember {
        mutableStateOf(true)
    }
    val (state2, onStateChange2) = remember {
        mutableStateOf(true)
    }
    
    // 根据这两个子Checkbox的状态设置TriStateCheckbox的状态
    val parentState = remember (state, state2){
        if (state && state2) ToggleableState.On
        else if (!state && !state2) ToggleableState.Off
        else ToggleableState.Indeterminate
    }

    // 同理，TriStateCheckbox的状态也可以用来设置两个子Checkbox的状态
    val onParentClick = {
        val s = parentState != ToggleableState.On
        onStateChange(s)
        onStateChange2(s)
    }

    Column {
        TriStateCheckbox(
            state = parentState,
            onClick = onParentClick,
            colors = CheckboxDefaults.colors(checkedColor = MaterialTheme.colors.primary)
        )
        Column(Modifier.padding(10.dp, 0.dp, 0.dp, 0.dp)) {
            Checkbox(checked = state, onCheckedChange = onStateChange)
            Checkbox(checked = state2, onCheckedChange = onStateChange2)
        }
    }
}

@Composable
fun SwitchTest() {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Switch(checked = checkedState.value, onCheckedChange = { checkedState.value = it })
}

@Preview(showBackground = true)
@Composable
fun SliderTest() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    val viewSliderPosition = sliderPosition * 100
    Column(modifier = Modifier.padding(10.dp)) {
        Text(text = "${viewSliderPosition.toInt()}%")
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })
    }
}