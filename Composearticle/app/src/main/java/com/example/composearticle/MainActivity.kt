package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.composearticle.ui.theme.ComposeArticleTheme

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    article_activity(stringResource(R.string.name_of_article), stringResource(R.string.middle_string), stringResource(R.string.text))
                }
            }
        }
    }
}

@Composable
fun article_activity(name_of_article: String, middle_string: String, text: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier.fillMaxHeight()
    ) {
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = name_of_article,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = middle_string,
            textAlign = TextAlign.Justify,
            modifier= Modifier.padding(
                start = 16.dp,
                end = 16.dp
            )
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    ComposeArticleTheme {
        article_activity(stringResource(R.string.name_of_article), stringResource(R.string.middle_string), stringResource(R.string.text))
    }
}