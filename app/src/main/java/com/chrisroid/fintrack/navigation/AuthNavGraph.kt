package com.chrisroid.fintrack.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.chrisroid.fintrack.ui.auth.accesscode.AccessCodeScreen
import com.chrisroid.fintrack.ui.auth.accountsetup.AccountSetupScreen
import com.chrisroid.fintrack.ui.auth.createpin.CreatePinScreen
import com.chrisroid.fintrack.ui.auth.login.LoginOTPScreen
import com.chrisroid.fintrack.ui.auth.login.LoginScreen
import com.chrisroid.fintrack.ui.auth.onboarding.OnboardingScreen
import com.chrisroid.fintrack.ui.auth.signup.SignUpScreen
import com.chrisroid.fintrack.ui.auth.signup.VerificationScreen
import com.chrisroid.fintrack.ui.auth.splash.SplashScreen

fun NavGraphBuilder.authNavGraph(navController: NavController) {
    navigation(
        startDestination = Routes.SPLASH,
        route = "auth"
    ) {
        composable(Routes.SPLASH) { SplashScreen(navController) }
        composable(Routes.ONBOARDING) { OnboardingScreen(navController) }
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.LOGIN_OTP) { LoginOTPScreen(navController) }
        composable(Routes.SIGNUP) { SignUpScreen(navController) }
        composable(Routes.VERIFICATION) { VerificationScreen(navController) }
        composable(Routes.ACCESS_CODE) { AccessCodeScreen(navController) }
        composable(Routes.ACCOUNT_SETUP) { AccountSetupScreen(navController) }
        composable(Routes.CREATE_PIN) {
            CreatePinScreen {
                navController.navigate(Routes.MAIN_HOME) {
                }
            }
        }
    }
}