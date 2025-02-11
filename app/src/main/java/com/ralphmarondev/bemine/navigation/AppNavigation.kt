package com.ralphmarondev.bemine.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ralphmarondev.bemine.MyApp
import com.ralphmarondev.bemine.core.preferences.AppPreferences
import com.ralphmarondev.bemine.features.home.HomeScreen
import com.ralphmarondev.bemine.features.nope.DealScreen
import com.ralphmarondev.bemine.features.nope.NopeFirstScreen
import com.ralphmarondev.bemine.features.yes.EatScreen
import com.ralphmarondev.bemine.features.yes.ExcitedScreen
import com.ralphmarondev.bemine.features.yes.SeeYouScreen
import com.ralphmarondev.bemine.features.yes.WatchScreen
import com.ralphmarondev.bemine.features.yes.WhenScreen
import com.ralphmarondev.bemine.features.yes.YesFirstScreen

@Composable
fun AppNavigation(
    preferences: AppPreferences = MyApp.preferences,
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
                    navController.navigate(Routes.Nope.OhNo) {
                        launchSingleTop = true
                    }
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
                },
                preferences = preferences
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
                },
                preferences = preferences
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
                },
                preferences = preferences
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
                },
                preferences = preferences
            )
        }

        composable<Routes.Nope.OhNo> {
            NopeFirstScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                onNext = {
                    navController.navigate(Routes.Nope.Deal) {
                        launchSingleTop = true
                    }
                }
            )
        }
        composable<Routes.Nope.Deal> {
            DealScreen(
                navigateBack = {
                    navController.navigateUp()
                },
                onNext = {
                    navController.navigate(Routes.Yes.Yay) {
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}