package com.example.businesscard


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    val context = LocalContext.current
    BusinessCard(context)
}

@Composable
private fun BusinessCard(context: Context) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(0xFF3c4f4d9))
            .fillMaxSize()
    )
    {
        BusinessCard_first_item(
            image = painterResource(R.drawable.android_logo),
            name = stringResource(R.string.name),
            title = stringResource(R.string.title_under_name),
        )

        BusinessCard_second_item(
            phone_num = stringResource(R.string.phone_num),
            name_link = stringResource(R.string.share_link),
            mail = stringResource(R.string.mail),
            context = context
        )
    }
}

@Composable
private fun BusinessCard_first_item(image: Painter, name: String, title: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxHeight(0.8f)
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .background(Color(0xFF275b82))
                .align(alignment = Alignment.CenterHorizontally)
                .size(150.dp)
        )
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF000000),
            fontSize = 45.sp
        )
        Text(
            text = title,
            fontSize = 27.sp,
            color = Color(0xFF136207)
        )
    }
}

@Composable
private fun BusinessCard_second_item(phone_num: String, name_link: String, mail: String, context: Context) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth(0.7f)
    ) {
        Row{
            Icon(
                imageVector = Icons.Rounded.Phone,
                contentDescription = "smth",
                tint = Color(0xFF136207),
                modifier = Modifier
                    .weight(0.32f)
                    .size(30.dp)
            )
            ClickableText(
                text = phone_num,
                modifier = Modifier.weight(0.8f),
                onClick = { openPhoneDialer(context, phone_num) }
            )
        }
        Row {
            Icon(
                imageVector = Icons.Rounded.Send,
                contentDescription = "smth",
                tint = Color(0xFF136207),
                modifier = Modifier
                    .weight(0.32f)
                    .size(25.dp)
            )

            ClickableText(
                text = name_link,
                modifier = Modifier.weight(0.8f),
                onClick = { openTelegram(context, name_link) }
            )
        }
        Row {
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "smht",
                tint = Color(0xFF136207),
                modifier = Modifier
                    .weight(0.32f)
                    .size(25.dp)
            )
            ClickableText(
                text = mail,
                modifier = Modifier.weight(0.8f),
                onClick = { openEmailClient(context, mail) }
            )
        }
    }
}

@Composable
fun ClickableText(
    text: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val annotatedText = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = Color(0xFF136207),
                textDecoration = TextDecoration.Underline
            )
        ) {
            append(text)
            addStringAnnotation(
                tag = "ClickableText",
                annotation = "",
                start = 0,
                end = text.length
            )
        }
    }

    Text(
        text = annotatedText,
        modifier = modifier.clickable { onClick() },
        fontSize = 18.sp,
        overflow = TextOverflow.Ellipsis
    )
}

private fun openPhoneDialer(context: Context, phoneNum: String) {
    val intent = Intent(Intent.ACTION_DIAL)
    intent.data = Uri.parse("tel:$phoneNum")
    context.startActivity(intent)
}

private fun openTelegram(context: Context, username: String) {
    val intent = Intent(Intent.ACTION_VIEW)
    intent.data = Uri.parse("https://t.me/$username")
    context.startActivity(intent)
}

private fun openEmailClient(context: Context, email: String) {
    val intent = Intent(Intent.ACTION_SENDTO)
    intent.data = Uri.parse("mailto:$email")
    context.startActivity(intent)
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}
