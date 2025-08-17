package com.example.animations.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
sealed class Destination {
    @Serializable
    object Box : Destination()
    @Serializable
    object List : Destination()
}