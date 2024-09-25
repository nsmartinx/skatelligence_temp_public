package com.example.skatelligenceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.skatelligenceapp.ui.theme.SkatelligenceAppTheme

@Composable
fun HomePage(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally, // Centers all content horizontally
        verticalArrangement = Arrangement.Top // Aligns content at the top of the screen
    ) {
        // Logo at the top
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "App Logo",
            modifier = Modifier
                .size(200.dp)  // Adjust the size as needed
                .align(Alignment.CenterHorizontally)  // Center the logo horizontally
        )

        Spacer(modifier = Modifier.height(16.dp)) // Space between logo and text

        // Explanation text centered below the logo
        Text(
            text = "AI Powered Figure Skating Analysis Tool.\n" +
                    "For more information, click on \"Track Jumps\"\n" +
                    "For detailed analysis of your jumps, click on \"View Insights\"",
            modifier = Modifier.align(Alignment.CenterHorizontally), // Center the text
            style = androidx.compose.material3.MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(32.dp)) // Space between the text and buttons

        // Navigation Buttons for Track Jumps and View Insights
        Button(onClick = { navController.navigate("trackJumps") }) {
            Text(text = "Track Jumps")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navController.navigate("viewInsights") }) {
            Text(text = "View Insights")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomePagePreview() {
    SkatelligenceAppTheme {
        HomePage(rememberNavController())
    }
}
