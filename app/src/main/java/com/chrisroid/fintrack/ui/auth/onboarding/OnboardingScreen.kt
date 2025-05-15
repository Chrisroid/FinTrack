package com.chrisroid.fintrack.ui.auth.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.chrisroid.fintrack.R
import com.chrisroid.fintrack.navigation.Routes
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
        Spacer(modifier = Modifier.height(40.dp))

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


        Spacer(modifier = Modifier.height(24.dp))

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

        Button(
            onClick = { navController.navigate(Routes.SIGNUP) },
            shape = CircleShape,
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007D82),
                contentColor = Color.White
            )
        ) {
            Text("Create an account")
        }

        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("Already have an account? ")
            TextButton(onClick = { navController.navigate(Routes.LOGIN) }) {
                Text("Sign in", color = Color(0xFF007D82))
            }
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

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = page.title,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = page.description,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            color = Color.DarkGray,
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
