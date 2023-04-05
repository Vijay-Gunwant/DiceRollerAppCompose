package com.example.dicerollerapp_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dicerollerapp_compose.ui.theme.DiceRollerApp_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerApp_ComposeTheme {
                MyApp()
            }
        }
    }
}

@Preview
@Composable
fun MyApp(){
    DiceAndImage(
        modifier =
        Modifier
            .fillMaxSize()
            .wrapContentSize(
                Alignment.Center
            )
    )
}

@Composable
fun DiceAndImage(modifier: Modifier ){
    var result by remember {
        mutableStateOf(1)
    }
    var image = when(result){
        1->R.drawable.dice_1
        2->R.drawable.dice_2
        3->R.drawable.dice_3
        4->R.drawable.dice_4
        5->R.drawable.dice_5
        else->R.drawable.dice_6

    }
    Column(
    modifier,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(
            painter = painterResource(id = image),
            contentDescription =result.toString()
        )
        Spacer(modifier =Modifier.height(16.dp))
        Button(onClick = { result = (1..6).random() }) {
            Text(
                text = stringResource(id = R.string.roll),
                fontSize = 40.sp,
            )
        }
    }
}


