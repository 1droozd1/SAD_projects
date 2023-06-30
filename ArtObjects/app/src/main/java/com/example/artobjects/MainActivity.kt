package com.example.artobjects

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artobjects.ui.theme.ArtObjectsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtObjectsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtObjectsApp()
                }
            }
        }
    }
}

@Composable
fun ArtObjectsApp() {
    ArtObjectsDisplay()
}

@Composable
fun ArtObjectsDisplay() {
    var state by remember {
        mutableStateOf(1)
    }
    if (state > 4) {state = 1}
    if (state < 1) {state = 4}

    val imageResourse = when(state) {
        1 -> R.drawable.picture_1
        2 -> R.drawable.picture_2
        3 -> R.drawable.picture_3
        4 -> R.drawable.picture_4

        else -> R.drawable.picture_1
    }

    val artistResourse = when(state) {
        1 -> R.string.first_art_artist
        2 -> R.string.second_art_artist
        3 -> R.string.third_art_artist
        4 -> R.string.fourth_art_artist

        else -> R.string.first_art_artist
    }

    val nameResourse = when(state) {
        1 -> R.string.first_art_name
        2 -> R.string.second_art_name
        3 -> R.string.third_art_name
        4 -> R.string.fourth_art_name

        else -> R.string.first_art_name
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(Color(0xFFcbcdcc))
                .padding(20.dp)
        ) {
            Image(
                painter = painterResource(imageResourse),
                contentDescription = null,
                modifier = Modifier
            )
        }

        Column(
            modifier = Modifier
            .fillMaxHeight(0.6f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(nameResourse),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = stringResource(artistResourse),
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(18.dp))

            Row {
                Button(
                    onClick = {state -= 1},
                    modifier = Modifier
                        .padding(end = 15.dp)
                ) {
                    Text(
                        text = "Previous",
                        fontSize = 20.sp
                    )
                }
                Button(onClick = {state += 1}) {
                    Text(
                        text = "Next",
                        fontSize = 20.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ArtObjectsPreview() {
    ArtObjectsTheme {
        ArtObjectsApp()
    }
}