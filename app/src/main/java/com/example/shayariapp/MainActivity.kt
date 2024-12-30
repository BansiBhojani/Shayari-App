package com.example.shayariapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shayariapp.ui.theme.ShayariAppTheme
var data = mutableStateListOf<String>("    Dosti Shayari","  Sad Shayari","  Romentic Shayari ","  Birthday Shayari","  Happy Shayari","  Friendship Shayari ","  Attitude Shayari","  Funny Shayari","  Best Wishes Shayari","Exam Shayari","Good Morning Shayari","Good Night Shayari","  Other Shayari")

class MainActivity : ComponentActivity() {
    @SuppressLint("InvalidColorHexValue", "UnrememberedMutableState")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShayariAppTheme {
                Scaffold(topBar = {
                    CenterAlignedTopAppBar(

                        title = { Text(text = "My Shayari", fontSize =30.sp,color = Color(0xFF89079E)) },
                        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFDF94EB))

                    )
                })

                { innerPadding ->
                    LazyColumn(
                        modifier = Modifier
                            .padding(paddingValues = innerPadding)
                            .background(Color(0xFFE970FD))
                            .fillMaxSize().padding(10.dp)
                    )
                    {
                        var image= mutableStateListOf(
                            R.drawable.dosti,
                            R.drawable.sad,
                            R.drawable.romentic,
                            R.drawable.birthday,
                            R.drawable.happy,
                            R.drawable.dosti,
                            R.drawable.attitude,
                            R.drawable.funny,
                            R.drawable.bestwishes,
                            R.drawable.exam,
                            R.drawable.morning,
                            R.drawable.night,
                            R.drawable.happy
                            )
                        items(data.size) {
                            Card(
                                modifier =
                                Modifier
                                    .fillMaxWidth()
                                    .width(30.dp)
                                    .height(110.dp).padding(5.dp),
                                colors = CardDefaults.cardColors(containerColor = Color(0xFF8BB3F6))

                            ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .size(50.dp).padding(1.dp)

                                ) {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth().weight(1f)
                                        .size(50.dp).padding(1.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically

                                ) {

                                    Image(
                                        painter = painterResource(image[it]),
                                        contentDescription = null,
                                        modifier = Modifier
                                            .size(60.dp, 50.dp)
                                    )
                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth().weight(2f)
                                        .padding(1.dp),
                                    horizontalArrangement = Arrangement.Center,
                                    verticalAlignment = Alignment.CenterVertically

                                ) {
                                    Text(
                                        text = data[it],
                                        fontSize = 20.sp,
                                        textAlign = TextAlign.Center,
                                        color = Color.Black
                                    )

                                }
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth().weight(.5f)
                                        .padding(1.dp),
                                    horizontalArrangement = Arrangement.Start,
                                    verticalAlignment = Alignment.CenterVertically

                                ) {

                                    Image(painter = painterResource(R.drawable.arrow),
                                        contentDescription = null,
                                        modifier = Modifier.size(200.dp,200.dp)
                                            .clickable {
                                                var change =
                                                    Intent(applicationContext, design::class.java)
                                                change.putExtra("pos", it)
                                                startActivity(change)
                                            }
                                        ,
                                        alignment = Alignment.BottomEnd
                                    )

                                }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

