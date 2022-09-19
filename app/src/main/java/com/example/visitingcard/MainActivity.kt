package com.example.visitingcard

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.materialIcon
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.visitingcard.ui.theme.VisitingCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VisitingCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    VisitingCardApp()
                }
            }
        }
    }
}

@Composable
fun VisitingCardApp() {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        Modifier
            .fillMaxSize()
            .background(Color(0xFF018786))
    ) {
        //Spacer(modifier = Modifier.height(150.dp))

        NameAndOfficeCard(
            fullName = "Jennifer Doe",
            title = "Android Developer Extraordinaire",
            image = image,
            modifier = Modifier.weight(12f)
        )

        //Spacer(modifier = Modifier.height(150.dp))

        InfomationCard(icon = Icons.Rounded.Phone,
            content = "+11 (123) 444 555 666", modifier = Modifier.weight(1f))
        InfomationCard(content = "@AndroidDev",
            icon = Icons.Rounded.Share, modifier = Modifier.weight(1f))
        InfomationCard(content = "jen.doe@android.com",
            icon = Icons.Rounded.Email, modifier = Modifier.weight(2f))
    }
}

@Composable
fun InfomationCard(
    content : String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Divider(color = Color.White, thickness = 2.dp)
        Row(
            modifier = Modifier
                .padding(start = 48.dp, top = 10.dp, bottom = 10.dp)
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "null",
                tint = Color(0xFF3ddc84)
                )
            Text(
                text = content,
                fontSize = 20.sp,
                color = Color.White,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

@Composable
fun NameAndOfficeCard(
    fullName: String,
    title: String,
    image: Painter,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .height(100.dp)
            )
        Text(
            text = fullName,
            fontSize = 48.sp,
            color = Color.White
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = Color(0xFF3ddc84),
            modifier = Modifier.padding(top = 16.dp)
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    VisitingCardTheme {
        VisitingCardApp()
    }
}