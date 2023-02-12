package com.example.commoncomposabletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.commoncomposabletest.ui.theme.CommonComposableTestTheme

class DIalogComposable : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommonComposableTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CircleProgressIndicatorTest()
                }
            }
        }
    }
}

@Composable
fun Greeting4(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview4() {
    CommonComposableTestTheme {
        Greeting4("Android")
    }
}

@Composable
fun DialogTest() {
    val openDialog = remember {
        mutableStateOf(true)
    }
    val dialogWidth = 200.dp
    val dialogHeight = 50.dp
    if (openDialog.value){
        Dialog(onDismissRequest = { openDialog.value = false }) {
            Box(modifier = Modifier
                .size(dialogWidth, dialogHeight)
                .background(Color.White))
        }
    }
}

@Composable
fun AlertDialogTest() {
    val openDialog = remember {
        mutableStateOf(true)
    }
    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = { openDialog.value = false },
            title = { Text(text = "开启位置服务") },
            text = { Text(text = "这将意味着，我们会给你提供精准的位置服务......")},
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(text = "同意")
                }
            },
            dismissButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text(text = "拒绝")
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircleProgressIndicatorTest() {
    var progress by remember {
        mutableStateOf(0.1f)
    }

    // 根据progress变量，创建一个动画
    val animatedProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec
    )
    Column {
        CircularProgressIndicator(progress = animatedProgress, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.requiredHeight(30.dp))
        OutlinedButton(onClick = { if (progress < 1f) progress += 0.1f }) {
            Text(text = "增加进度")
        }
    }
}