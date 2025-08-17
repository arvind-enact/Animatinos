package com.example.animations.ui.screens

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun BoxScreen(modifier: Modifier = Modifier) {
    var isBlue by rememberSaveable { mutableStateOf(false) }
    val transition = updateTransition(isBlue)
    val color by transition.animateColor { if (it) Color.Blue else Color.Orange }
    val size by transition.animateDp(transitionSpec = {
        if (targetState) {
            spring(stiffness = Spring.StiffnessLow)
        } else {
            spring(stiffness = Spring.StiffnessMedium)
        }
    }) { if (it) 200.dp else 100.dp }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
    ) {
        Button(onClick = { isBlue = !isBlue }) {
            Text(text = "Toggle Color")
        }

        ColorBox(
            modifier = Modifier
                .size(size)
                .aspectRatio(1f),
            color = color,
        )
    }
}

@Composable
fun ColorBox(modifier: Modifier, color: Color) {
    Box(
        modifier = modifier
            .clip(MaterialTheme.shapes.extraLarge)
            .background(color, MaterialTheme.shapes.extraLarge)
    )
}

private val Color.Companion.Orange
    get() = Color(0xFFFFA500)
