package com.ralphmarondev.bemine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.bemine.features.home.HomeScreen
import com.ralphmarondev.bemine.features.yes.EatScreen
import com.ralphmarondev.bemine.features.yes.ExcitedScreen
import com.ralphmarondev.bemine.features.yes.SeeYouScreen
import com.ralphmarondev.bemine.features.yes.WatchScreen
import com.ralphmarondev.bemine.features.yes.WhenScreen
import com.ralphmarondev.bemine.features.yes.YesFirstScreen

@Composable
fun AppNavigation(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home
    ) {
        composable<Routes.Home> {
            HomeScreen(
                onYes = {
                    navController.navigate(Routes.Yes.Yay) {
                        launchSingleTop = true
                    }
                },
                onNope = {

                }
            )
        }

        composable<Routes.Yes.Yay> {
            YesFirstScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                onNext = {
                    navController.navigate(Routes.Yes.When) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Routes.Yes.When> {
            WhenScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                onNext = {
                    navController.navigate(Routes.Yes.Eat) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Routes.Yes.Eat> {
            EatScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                onNext = {
                    navController.navigate(Routes.Yes.Watch) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Routes.Yes.Watch> {
            WatchScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                onNext = {
                    navController.navigate(Routes.Yes.Excited) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Routes.Yes.Excited> {
            ExcitedScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                onNext = {
                    navController.navigate(Routes.Yes.SeeYou) {
                        launchSingleTop = true
                    }
                }
            )
        }

        composable<Routes.Yes.SeeYou> {
            SeeYouScreen(
                navigateBack = {
                    navController.navigateUp()
                }
            )
        }
    }
}