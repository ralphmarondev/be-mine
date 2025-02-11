package com.ralphmarondev.bemine.navigation

import kotlinx.serialization.Serializable

object Routes {

    @Serializable
    data object Home

    @Serializable
    object Yes {
        @Serializable
        data object Yay

        @Serializable
        data object When

        @Serializable
        data object Eat

        @Serializable
        data object Watch

        @Serializable
        data object Excited

        @Serializable
        data object SeeYou
    }

    @Serializable
    object Nope {
        @Serializable
        data object OhNo

        @Serializable
        data object Deal
    }
}