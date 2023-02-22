package com.example.lazylisttest

import android.graphics.BitmapFactory.Options
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazylisttest.ui.theme.LazyListTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyListTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ContentPaddingTest()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    LazyListTestTheme {
        Greeting("Android")
    }
}

@Composable
fun LazyListTest() {
    LazyColumn(
        content = {
            item { Text(text = "这是第1项内容") }
            items(5) { index -> Text(text = "这是第${index + 2}项内容")}
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MenuTest(
    options: List<Options>,
    expanded: Boolean,
    onDismissRequest: () -> Unit
) {
    DropdownMenu(expanded = expanded, onDismissRequest = onDismissRequest) {
        LazyColumn(
            content = {
                items(options) {
                        options -> ListItem( text = { Text(text = "过编译") })//text = Text(text = options.text)
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ContentPaddingTest() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        contentPadding = PaddingValues(35.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(50) { index ->
            ContentCard(index = index)
        }
    }
}

@Composable
fun ContentCard(index: Int) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "我是序号第${index}位的卡片", 
                style = MaterialTheme.typography.h5
            )
        }
    }
}