package com.example.composequadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.RowScopeInstance.weight
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.composequadrant.ui.theme.ComposeQuadrantTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeQuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    compose_quadrantApp()
                }
            }
        }
    }
}

@Composable
fun compose_quadrantApp(){
    compose_quadrantCard(
        title_1 = stringResource(R.string.title_text),
        text_1 = stringResource(R.string.text_text),
        title_2 = stringResource(R.string.title_row),
        text_2 = stringResource(R.string.row_text),
        title_3 = stringResource(R.string.title_image),
        text_3 = stringResource(R.string.image_text),
        title_4 = stringResource(R.string.title_column),
        text_4 = stringResource(R.string.column_text),
        modifier =  Modifier
    )
}

@Composable
private fun compose_quadrantCard(
    title_1: String,
    text_1: String,
    title_2: String,
    text_2: String,
    title_3: String,
    text_3: String,
    title_4: String,
    text_4: String,
    modifier: Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
    ){
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {// первая колонка
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color(0xFFEADDFF))
                    .padding(16.dp)
                    .fillMaxHeight(0.5f)
            ) {
                Text(
                    text = title_1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                )
                Text(
                    text = text_1,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                            .align(alignment = Alignment.CenterHorizontally)
                )
            }

            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color(0xFFB69DF8))
                    .padding(16.dp)
                    .fillMaxHeight(1f)
            ) {
                Text(
                    text = title_2,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = text_2,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                )
            }
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {// первая колонка
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color(0xFFD0BCFF))
                    .padding(16.dp)
                    .fillMaxHeight(0.5f)
            ) {
                Text(
                    text = title_3,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = text_3,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                )
            }

            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .background(Color(0xFFF6EDFF))
                    .padding(16.dp)
                    .fillMaxHeight()
            ) {
                Text(
                    text = title_4,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = text_4,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeQuadrantTheme {
        compose_quadrantApp()
    }
}