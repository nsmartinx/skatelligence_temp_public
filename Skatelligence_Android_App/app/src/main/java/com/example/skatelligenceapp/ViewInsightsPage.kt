package com.example.skatelligenceapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skatelligenceapp.ui.theme.SkatelligenceAppTheme

// Data class to hold jump information
data class JumpInfo(
    val name: String,
    val airTime: String,
    val height: String,
    val totalRotation: String
)

@Composable
fun ViewInsightsPage() {
    // State for managing dropdown visibility
    var showDropdown by remember { mutableStateOf(false) }

    val options = listOf("axel.bin", "lutz.bin", "salchow.bin", "toe.bin", "flip.bin", "loop.bin")

    // Map to hold information about each jump
    val jumpInfoMap = mapOf(
        "axel.bin" to JumpInfo(
            name = "Single Axel",
            airTime = "0.31",
            height = "0.32",
            totalRotation = "523"
        ),
        "lutz.bin" to JumpInfo(
            name = "Single Lutz",
            airTime = "0.34",
            height = "0.32",
            totalRotation = "350"
        ),
        "salchow.bin" to JumpInfo(
            name = "Single Salchow",
            airTime = "0.34",
            height = "0.31",
            totalRotation = "351"
        ),
        "toe.bin" to JumpInfo(
            name = "Single Toe",
            airTime = "0.29",
            height = "0.25",
            totalRotation = "323"
        ),
        "flip.bin" to JumpInfo(
            name = "Single Flip",
            airTime = "0.28",
            height = "0.27",
            totalRotation = "357"
        ),
        "loop.bin" to JumpInfo(
            name = "Single Axel",
            airTime = "0.27",
            height = "0.28",
            totalRotation = "342"
        )
    )

    // State to hold the selected option and its info
    var selectedOption by remember { mutableStateOf(options.first()) }
    var selectedJumpInfo by remember { mutableStateOf(jumpInfoMap[selectedOption]) }

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
            text = "View Performance Insights",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Review detailed performance insights, including jump types, rotation amount, height, and more, based on AI analytics.",
            style = MaterialTheme.typography.bodyMedium
        )
        Spacer(modifier = Modifier.height(20.dp))

        TextButton(
            onClick = { showDropdown = !showDropdown },
            content = {
                Text(text = "Select Option: $selectedOption")
            }
        )

        DropdownMenu(
            expanded = showDropdown,
            onDismissRequest = { showDropdown = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(text = option) },
                    onClick = {
                        selectedOption = option
                        selectedJumpInfo = jumpInfoMap[option]
                        showDropdown = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Display selected jump information
        selectedJumpInfo?.let { info ->
            Text(text = "Jump Type: ${info.name}")
            Text(text = "Air time: ${info.airTime} seconds")
            Text(text = "Max Height: ${info.height} metres")
            Text(text = "Total Rotation: ${info.totalRotation} deg")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewInsightsPagePreview() {
    SkatelligenceAppTheme {
        ViewInsightsPage()
    }
}
