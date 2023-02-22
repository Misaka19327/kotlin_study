package com.example.layouttest

import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.layouttest.ui.theme.LayoutTestTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ScaffoldTest()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun DefaultPreview() {
    LayoutTestTheme {
        Greeting("Android")
    }
}

@Composable
fun ColumnTest() {
    Column(
        modifier = Modifier
            .border(1.dp, Color.Black)
            .size(150.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "Hello World!",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(text = "Jetpack Compose")
    }
}

@Composable
fun RowTest() {
    Surface(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(horizontal = 12.dp) // 设置Surface的外边距
            .fillMaxWidth(),
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp) // 设置里面内容的外边距
        ) {
            Text(
                text = "Jetpack 是什么",
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.padding(vertical = 5.dp))
            Text(
                text = "Jetpack Compose是用于构建原生Android界面的新工具包，它可以简化并且加快Android上的界面开发，使用更少的代码，强大的工具和直观的Kotlin API让应用生动而精彩。"
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Call, contentDescription = null)
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Share, contentDescription = null)
                }
            }
        }
    }
}

@Composable
fun BoxTest() {
    Box {
        Box(modifier = Modifier
            .size(150.dp)
            .background(Color.Blue))
        Box(modifier = Modifier
            .size(50.dp)
            .background(Color.Red))
        Text(text = "Hello World!")
    }
}

@Composable
fun SurfaceTest() {
    Surface(
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp,
        modifier = Modifier
            .width(300.dp)
            .height(100.dp)
    ) {
        Row(modifier = Modifier.clickable(){  }) {
            Image(
                painter = painterResource(id = R.drawable.temp), 
                contentDescription = null, 
                modifier = Modifier.size(100.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.padding(horizontal = 12.dp))
            Column(
                modifier = Modifier.fillMaxHeight(), 
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Griseo", style = MaterialTheme.typography.h6)
                Spacer(modifier = Modifier.padding(vertical = 8.dp))
                Text(text = "格蕾修")
            }
        }
    }
}

@Composable
fun WidthSpacer(value: Dp) {
    Spacer(modifier = Modifier.padding(horizontal = value))
}

@Composable
fun ConstraintLayoutTest() {
    ConstraintLayout(modifier = Modifier
        .width(300.dp)
        .height(100.dp)
        .padding(10.dp)) {
        val (portraitImageRef, usernameTextRef, desTextRef) = remember {
            createRefs()
        }
        Image(
            painter = painterResource(id = R.drawable.temp),
            contentDescription = null,
            modifier = Modifier.constrainAs(portraitImageRef) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            }
        )
        Text(
            text = "格蕾修",
            fontSize = 16.sp,
            maxLines = 1,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .constrainAs(usernameTextRef){
                    top.linkTo(portraitImageRef.top)
                    start.linkTo(portraitImageRef.end, 10.dp)
                }
        )
        Text(
            text = "逐火十三英桀之一,喜欢画画的少女",
            fontSize = 14.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .constrainAs(desTextRef) {
                    top.linkTo(usernameTextRef.bottom, 5.dp)
                    start.linkTo(portraitImageRef.end, 10.dp)
                    end.linkTo(parent.end, 10.dp)
                    width = Dimension.preferredWrapContent
                }
        )
    }
}

@Composable
fun BarrierTest() {
    ConstraintLayout(
        modifier = Modifier
            .height(125.dp)
            .width(500.dp)
    ) {
        val (usernameTextRef, passwordTextRef, usernameInputRef, passwordInputRef, dividerRef) = remember {
            createRefs()
        }
        val barrier = createEndBarrier(usernameTextRef, passwordTextRef)
        Text(
            text = "用户名",
            Modifier.constrainAs(usernameTextRef) {
                top.linkTo(parent.top, 20.dp)
                start.linkTo(parent.start)
            }
        )
        Text(
            text = "密码",
            Modifier.constrainAs(passwordTextRef) {
                top.linkTo(usernameTextRef.bottom, 40.dp)
                start.linkTo(parent.start)
            }
        )
        OutlinedTextField(
            value = "请输入用户名",
            onValueChange = {},
            modifier = Modifier.constrainAs(usernameInputRef) {
                top.linkTo(parent.top)
                start.linkTo(barrier, 10.dp)
                baseline.linkTo(usernameTextRef.baseline)
            }
        )
        OutlinedTextField(
            value = "请输入密码",
            onValueChange = {},
            modifier = Modifier.constrainAs(passwordInputRef) {
                top.linkTo(usernameInputRef.bottom, 10.dp)
                start.linkTo(barrier, 10.dp)
                baseline.linkTo(passwordTextRef.baseline)
            }
        )
    }
}

@Composable
fun GuidelineTest() {
    ConstraintLayout(modifier = Modifier.size(500.dp)) {
        val guideline = createGuidelineFromTop(0.2f)
        val (userIconRef, userBackgroundRef) = remember {
            createRefs()
        }
        Box(
            modifier = Modifier
                .constrainAs(userBackgroundRef) {
                    top.linkTo(parent.top)
                    bottom.linkTo(guideline)
                    height = Dimension.fillToConstraints
                    width = Dimension.matchParent
                }
                .background(Color(0xFF1E9FFF))
        )
        Icon(
            imageVector = Icons.Outlined.Person,
            contentDescription = null,
            tint = Color(0xFF5FB878),
            modifier = Modifier
                .constrainAs(userIconRef) {
                    top.linkTo(guideline)
                    bottom.linkTo(guideline)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .size(100.dp)
                .clip(CircleShape)
                .border(width = 2.dp, color = Color(0xFF5FB878), shape = CircleShape)
        )
    }
}

@Composable
fun ChainTest() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (quotesFirstLineRef, quotesSecondLineRef, quotesThirdLineRef, quotesForthLineRef) = remember {
            createRefs()
        }
        createVerticalChain(
            quotesFirstLineRef,
            quotesSecondLineRef,
            quotesThirdLineRef,
            quotesForthLineRef,
            chainStyle = ChainStyle.Spread
        )
        Text(
            text = "做博士的护卫？好哦。",
            color = Color.Gray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(quotesFirstLineRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "爸爸不知道现在过得好不好......不过，感觉市长是一个说话算话的人，应该没问题吧。",
            color = Color.Gray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(quotesSecondLineRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "呼......一整天都呆在房间里感觉好闷。博士，我们一起去甲板上呼吸新鲜空气吧？博士工作了这么久也累了吧。",
            color = Color.Gray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(quotesThirdLineRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text = "多索雷斯虽然很吵闹，也有许多坏人，但是在那里的生活还是比在外面的玻利瓦尔要好许多呢......博士没有去过吗？那下次一起去吧。",
            color = Color.Gray,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .constrainAs(quotesForthLineRef) {
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
    }
}

data class Item(
    val name: String,
    val icon: ImageVector
)

@Preview(showBackground = true)
@Composable
fun ScaffoldTest() {
    val selectedItem by remember {
        mutableStateOf(0)
    }
    val items = listOf(
        Item("主页", Icons.Filled.Home),
        Item("列表", Icons.Filled.List),
        Item("设置", Icons.Filled.Settings)
    )
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "主页")
                },
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Menu, null)
                    }
                }
            )
        },
        bottomBar = {
            BottomNavigation {
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = selectedItem == index,
                        onClick = { selectedItem == index },
                        icon = { Icon(imageVector = item.icon, contentDescription = null) },
                        alwaysShowLabel = false,
                        label = { Text(text = item.name) }
                    )
                }
            }
        },
        drawerContent = { 
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Hello!")
                        }
        },
        scaffoldState = scaffoldState,
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center) {
            Text(text = "Hello World!")
        }
    }
    BackHandler(enabled = scaffoldState.drawerState.isOpen) {
        scope.launch {
            scaffoldState.drawerState.close()
        }
    }
}