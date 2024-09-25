package com.example.skatelligenceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skatelligenceapp.ui.theme.SkatelligenceAppTheme
import androidx.compose.foundation.text.ClickableText
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import android.content.Intent
import android.net.Uri
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp



@Composable
fun TrackJumpsPage() {
    val context = LocalContext.current
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        // Background image
        Image(
            painter = painterResource(id = R.drawable.background_1),
            contentDescription = null,
            contentScale = ContentScale.Crop,  // Makes the image cover the full screen
            modifier = Modifier.fillMaxSize()
        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(200.dp)
                .align(Alignment.CenterHorizontally)  // Center the logo horizontally
        )
        Text(
            text = "Track Your Jumps",
            style = androidx.compose.material3.MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Please see the website for more details, including a technical breakdown, instructions, and background:",
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        // Clickable text to open the website
        ClickableText(
            text = AnnotatedString("skatelligence.ca"),
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium.copy(
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline
            ),
            onClick = {
                // Open the URL in the browser using an Intent
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://skatelligence.ca"))
                context.startActivity(intent)
            }
        )
    }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackJumpsPagePreview() {
    SkatelligenceAppTheme {
        TrackJumpsPage()
    }
}
