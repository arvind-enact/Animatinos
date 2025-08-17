package com.example.animations.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.animations.navigation.Destination

private val screens: List<Destination> =
    Destination::class.sealedSubclasses.mapNotNull { it.objectInstance }

@Composable
fun HomeScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(vertical = 16.dp)) {
        items(screens) { destination ->
            Button(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 8.dp),
                onClick = { navController.navigate(destination) }
            ) {
                Text(text = destination::class.simpleName.orEmpty())
            }
        }
    }
}
