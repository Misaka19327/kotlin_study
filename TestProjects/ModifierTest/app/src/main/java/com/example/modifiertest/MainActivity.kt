package com.example.modifiertest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.modifiertest.ui.theme.ModifierTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ShowOffset()
                }
            }
        }
    }
}

@Composable
fun ShowPicture() {
    Row {
       Image(
           painterResource(id = R.drawable.pic2),
           modifier = Modifier
               .size(60.dp) // width和height同时设置为60dp
               .clip(CircleShape), // 将图片裁剪为圆形
           contentDescription = null
       )
    }
    Spacer(modifier = Modifier.width(10.dp))
    Image(
        painterResource(id = R.drawable.pic2),
        contentDescription = null,
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
    )
}

@Composable
fun ShowBackground() {
    // 创建 Brush 渐变色
    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color.Red,
            Color.Yellow,
            Color.White
        )
    )
    Row{
        Box(
            Modifier
                .size(50.dp)
                .background(color = Color.Red) // 设置纯色背景
        ) {
            Text("纯色", Modifier.align(Alignment.Center))
        }
        Spacer(Modifier.size(10.dp))
        Box(
            Modifier
                .size(50.dp)
                .background(brush = verticalGradientBrush) // 设置渐变色背景
        ) {
            Text(text = "渐变色", Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun ShowBorder() {
    Box(modifier = Modifier
        .padding(8.dp)
        .border(2.dp, Color.Red, shape = RoundedCornerShape(2.dp))
        .padding(8.dp)
    ) {
        Spacer(modifier = Modifier
            .size(width = 100.dp, height = 10.dp)
            .background(Color.Red)
        )
    }
}

@Composable
fun ShowOffset() {
    Box(modifier = Modifier
        .size(300.dp)
        .background(Color.Red)
    ){
        Spacer(modifier = Modifier
            .size(width = 100.dp, height = 10.dp)
            .offset(x = 200.dp, y = 150.dp)
            .background(Color.Green)
        )
    }
}

@Composable
@Preview
fun WeightModifierDemo() {
    Column(
        modifier = Modifier
            .width(300.dp)
            .height(200.dp)
    ) {
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.White)
        ) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "我是白色")
            }
        }
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Blue)
        ){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "我是蓝色")
            }
        }
        Box(modifier = Modifier
            .weight(1f)
            .fillMaxWidth()
            .background(Color.Red)
        ){
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "我是红色")
            }
        }
    }
}