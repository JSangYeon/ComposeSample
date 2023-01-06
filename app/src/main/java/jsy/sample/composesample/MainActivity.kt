package jsy.sample.composesample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jsy.sample.composesample.ui.theme.ComposeSampleTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("안드로이드 컴포저블 특징")
                }
            }
        }

        
    }
}

//플러터랑 마찬가지로 skip hold 지원 가능


// View 어노테이션 자체가 뷰가되고, 뷰안에 뷰를 넣을 수 있다 modifier, style 지정 가능
@Composable
fun Greeting(name: String) { //매개변수 name을 받아 TextView 생성
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("샘플앱") },
//            elevation = 0.dp,
                backgroundColor = Color(0xfff25287)
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {

                Text("클릭")
                /* FAB content */
            }
        }
    ) { //material Design 자체를 지원 appbar, bottom 등 다 지원함
        SampleComposableView() // Composable안에 Composable
    }
    Text(text = "안녕하세요 $name!")

}

@Composable
fun rowItem(){
    Row( //horizontal Linear
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically // 가운데정렬
    ){
        Text("ㅎㅇ",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow), color = Color.Blue)
        Spacer(modifier = Modifier.size(10.dp))
        Text("ㅎㅇ")
        Spacer(modifier = Modifier.size(10.dp))
        Text("ㅎㅇ")

    }
}

@Composable
fun SampleComposableView() { //네이밍 대문자로 시작 (뷰이기 떄문에) flutter와 swift ui와 같은패턴 / rn도 어느정도 비슷함 view에 State를 넣어서 상태값을 넣어서 변하는식으로 랜더링 가능

    Log.d("TAG", "SampleComposableView")


    //vertical Linear
    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ) {

        for ( i in 0..20){
            rowItem()
        }
//        rowItem()
//        rowItem()


    }

}

@Preview(showBackground = true) //@preview-> 미리보기 창
@Composable
fun DefaultPreview() {
    ComposeSampleTheme {
        Greeting("Android")
    }
}