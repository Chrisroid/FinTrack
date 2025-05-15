package com.chrisroid.fintrack.ui.auth.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.R
import com.chrisroid.fintrack.navigation.Routes
import com.chrisroid.fintrack.ui.base.CustomButton
import com.chrisroid.fintrack.ui.theme.appText
import com.google.accompanist.pager.*
import kotlinx.coroutines.launch

data class OnboardingPage(
    val imageRes: Int,
    val title: String,
    val description: String
)

val onboardingPages = listOf(
    OnboardingPage(
        R.drawable.onboarding_image1,
        "Track Your\nExpenses",
        "Get insights into where your money goes and make informed financial decisions."
    ),
    OnboardingPage(
        R.drawable.onboarding_image2,
        "Set Savings\nGoals",
        "Whether it’s for a vacation, a new car, or an emergency fund, we help you stay on track."
    ),
    OnboardingPage(
        R.drawable.onboarding_image3,
        "Get Financial\nInsights",
        "Access detailed reports and analytics to make better financial choices."
    )
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(navController: NavController) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        // ✅ Static Indicator (doesn't move with pager)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            repeat(3) { index ->
                Box(
                    modifier = Modifier
                        .height(4.dp)
                        .width(100.dp)
                        .background(
                            if (index == pagerState.currentPage) Color.Black else Color.LightGray,
                            shape = CircleShape
                        )
                )
                if (index != 2) Spacer(modifier = Modifier.width(8.dp))
            }
        }


        Spacer(modifier = Modifier.height(8.dp))

        // ✅ Pager below the indicator
        HorizontalPager(
            count = onboardingPages.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnboardingPageContent(
                page = onboardingPages[page],
                currentPage = pagerState.currentPage
            )
        }

        CustomButton(
            text = "Create an account",
            onClick = { navController.navigate(Routes.SIGNUP) },
        )

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "Already have an account? ",
                style = appText,
                fontSize = 16.sp
            )
            Text(
                text = "Sign in",
                style = appText.copy(
                    fontSize = 16.sp,
                    color = Color(0xFF008080)
                ),
                modifier = Modifier.clickable {
                    navController.navigate(Routes.LOGIN)
                }
            )
        }
    }
}

@Composable
fun OnboardingPageContent(page: OnboardingPage, currentPage: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = page.title,
            fontSize = 28.sp,
            style = appText,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = page.description,
            fontSize = 16.sp,
            style = appText,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = page.imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(320.dp)
        )
    }
}
