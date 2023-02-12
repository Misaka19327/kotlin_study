package com.example.commoncomposabletest

import android.content.Intent
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.core.content.ContextCompat.startActivity
import com.example.commoncomposabletest.ui.theme.CommonComposableTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CommonComposableTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        StartButtonComposable()
                        StartDialogComposable()
                        StartChooseComposable()
                    }
                }
            }
        }
    }
}

@Composable
fun StartButtonComposable() {
    val context = LocalContext.current
    Row(modifier = Modifier.size(200.dp)) {
        Button(
            onClick = {
                val intent = Intent(context, ButtonComposable::class.java)
                startActivity(context, intent, null)
            },
            modifier = Modifier.size(height = 50.dp, width = 250.dp)
        ) {
            Text(text = "Open ButtonComposable")
        }
    }
}

@Composable
fun StartChooseComposable() {
    val context = LocalContext.current
    Row(modifier = Modifier.size(200.dp)) {
        Button(
            onClick = {
                val intent = Intent(context, ChooseComposable::class.java)
                startActivity(context, intent, null)
            },
            modifier = Modifier.size(height = 50.dp, width = 250.dp)
        ) {
            Text(text = "Open ChooseComposable")
        }
    }
}

@Composable
fun StartDialogComposable() {
    val context = LocalContext.current
    Row(modifier = Modifier.size(200.dp)) {
        Button(
            onClick = {
                val intent = Intent(context, DIalogComposable::class.java)
                startActivity(context, intent, null)
            },
            modifier = Modifier.size(height = 50.dp, width = 250.dp)
        ) {
            Text(text = "Open DialogComposable")
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    CommonComposableTestTheme {
        Greeting("Android")
    }
}

@Composable
fun TextStyleTest() {
    Column {
        Text(text = "Hello World!\n" + "Goodbye World!")
        Text(
            text = "Hello World!\n" + "Goodbye World!",
            style = TextStyle(
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold, // 字体粗细
                background = Color.Cyan, // 背景
                lineHeight = 35.sp // 行高
                )
        )
        Text(
            text = "Hello World!",
            style = TextStyle(
                color = Color.Gray,
                letterSpacing = 4.sp // 字体间距
            )
        )
        Text(
            text = "Hello World!",
            style = TextStyle(
                textDecoration = TextDecoration.LineThrough // 删除线
            )
        )
        Text(
            text = "Hello World!",
            style = MaterialTheme.typography.h6.copy(fontStyle = FontStyle.Italic)
        )
    }
}

@Composable
fun MaxLinesTest() {
    Column {
        Text(
            text = "Hello World!我正在使用Jetpack Compose开发Android应用。",
            style = MaterialTheme.typography.body1
            )
        Text(
            text = "Hello World!我正在使用Jetpack Compose开发Android应用。",
            style = MaterialTheme.typography.body1,
            maxLines = 1
        )
        Text(
            text = "Hello World!我正在使用Jetpack Compose开发Android应用。",
            style = MaterialTheme.typography.body1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun FontFamilyTest() {
    val customFont = FontFamily(
        Font(resId = R.font.kaiti, style = FontStyle.Normal)
    )
    Column {
        Text(text = "Hello World!")
        Text(text = "Hello World!", fontFamily = FontFamily.Monospace)
        Text(text = "Hello World!", fontFamily = FontFamily.Cursive)
        Text(text = "你好世界!", fontFamily = customFont, fontStyle = FontStyle.Normal)
    }
}

@Composable
fun AnnotatedStringTest() {
    Text(
        text = buildAnnotatedString {
            withStyle(style = SpanStyle(fontSize = 24.sp)){
                append("你现在学习的章节是")
            }
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.W900,
                    fontSize = 24.sp
                )
            ) {
                append("Text")
            }
            append("\n")
            withStyle(
                style = ParagraphStyle(lineHeight = 25.sp)
            ) {
                append("在刚刚讲过的内容中，我们学会了如何应用文字样式，以及如何限制文本的行数和处理溢出的视觉效果")
                append("\n")
                append("现在，我们正在学习 ")
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.W900,
                        textDecoration = TextDecoration.Underline,
                        color = Color(0xFF59A869)
                    )
                ) {
                    append("AnnotatedString")
                }
            }
        }
    )
}

@Composable
fun ClickTextWithAnnotatedStringTest() {
    val annotatedText = buildAnnotatedString {
        withStyle(style = ParagraphStyle(lineHeight = 25.sp)) {
            append("Click ")
            // 为pushStringAnnotation和pop之间的区域添加标签
            pushStringAnnotation(tag = "URL", annotation = "https://www.baidu.com")
            withStyle(
                style = SpanStyle(
                    fontWeight = FontWeight.W900,
                    textDecoration = TextDecoration.Underline,
                    color = Color(0xFF59A869)
                )
            ) {
                append("AnnotatedString")
            }
            pop()
        }
    }
    ClickableText(
        text = annotatedText,
        onClick = {offset ->
            // 获取被点击区域的标签为URL的annotation并进行处理
            annotatedText.getStringAnnotations(
                tag = "URL",
                start = offset,
                end = offset
            ).firstOrNull()?.let {
                annotation -> Log.d("MainActivity", annotation.item)
            }
        }
    )
}

@Composable
fun SimpleClickedTextTest() {
    ClickableText(
        text = AnnotatedString("Click me", spanStyle = SpanStyle(color = Color.White)),
        onClick = {
            offset -> Log.d("MainActivity", "$offset -th character is clicked.")
        }
    )
}

@Composable
fun SelectionContainerTest() {
    SelectionContainer {
        Text(text = "Selection Container")
    }
}

@Composable
fun TextFieldTest() {
    var text by remember{ mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(text = "用户名")}
    )
}

@Composable
fun TextFieldDecorationTest() {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column {
        TextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = {
                Text(text = "用户名")
            },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.AccountBox, contentDescription = "用户名")
            }
        )
        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text("密码")
            },
            trailingIcon = {
                IconButton(onClick = { }) {
                    /*
                    Icon(painter = painterResource(id = "这里填R资源的id"), contentDescription = "密码")
                     */
                }
            }
        )
    }
}

@Composable
fun OutlinedTextFieldTest() {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text(text = "用户名")})
}

@Composable
fun BasicTextFieldTest() {
    var username by remember {
        mutableStateOf("")
    }
    BasicTextField(
        value = username,
        onValueChange = {username = it},
        decorationBox = { innerTextField ->
            Column {
                innerTextField()
                Divider(
                    thickness = 2.dp, // 分割线的宽度
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Black)
                )
            }
        }
    )
}

@Composable
fun SearchBarTest() {
    var text by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD3D3D3)),
        contentAlignment = Alignment.Center
    ) {
        BasicTextField(
            value = text,
            onValueChange = {text = it},
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(vertical = 2.dp, horizontal = 8.dp)
                ) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = null, tint = Color.Black)
                    Box(
                        modifier = Modifier.padding(horizontal = 10.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (text.isEmpty()) {
                            Text(
                                text = "输入点东西试试看吧~",
                                style = TextStyle(
                                    color = Color(0, 0, 0, 128)
                                )
                            )
                        }
                        innerTextField()
                    }
                    if (text.isNotEmpty()) {
                        IconButton(
                            onClick = { text = "" },
                            modifier = Modifier.size(16.dp)
                        ) {
                            Icon(imageVector = Icons.Filled.Close, contentDescription = null, tint = Color.Black)
                        }
                    }
                }
            },
            modifier = Modifier
                .padding(horizontal = 10.dp)
                .background(Color.White, CircleShape)
                .height(30.dp)
                .fillMaxWidth()
        )
    }
}