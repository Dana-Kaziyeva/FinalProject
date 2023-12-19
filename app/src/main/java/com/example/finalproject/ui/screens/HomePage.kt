package com.example.finalproject.ui.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.finalproject.InventoryTopAppBar
import com.example.finalproject.R

class Pair {
    val desc = ""
    val author = ""

}
    val motivation_list = listOf(
        Pair("Nothing is impossible, the word itself says \"I'm possible\"!",
            "Audrey Hepburn"),
        Pair("To win big, you sometimes have to take big risks.",
            "Bill Gates"),
        Pair("Setting goals is the first step in turning the invisible into the visible.",
            "Tony Robbins"),
        Pair("If you have built castles in the air, your work need not be lost; that is where they should be. Now put the foundations under them.",
            "Henry David Thoreau"),
        Pair("A goal is not always meant to be reached, it often serves simply as something to aim at.",
            "Bruce Lee"),
        Pair("It's up to you to make your life. Take what you have and stack it up like a tower of teetering blocks. Build your dream around that.",
            "Cheryl Strayed"),
        Pair("I do know that when I am 60, I should be attempting to achieve different personal goals than those which had priority at age 20.",
            "Warren Buffett"),
        Pair("You measure the size of the accomplishment by the obstacles you have to overcome to reach your goals.",
            "Booker T. Washington"),
        Pair("You are never too old to set a new goal or to dream a new dream.",
            "C.S. Lewis"),
        Pair("This is my invariable advice to people: Learn how to cook -- try new recipes, learn from your mistakes, be fearless and above all have fun!",
            "Julia Child"),
        Pair("You're always working to improve, and you're always being critiqued on your next performance. It's not about what you've done. There's always room to grow.",
            "Misty Copeland"),
        Pair("If we have a goal and a plan, and are willing to take risks and mistakes and work as team, we can choose to do the hard thing.",
            "Scott Kelly"),
        Pair("Some failure in life is inevitable. It is impossible to live without failing at something, unless you live so cautiously that you might as well not have lived at all -- in which case, you fail by default.",
            "J.K. Rowling"),
        Pair("Never give up. Today is hard, tomorrow will be worse, but the day after tomorrow will be sunshine.",
            "Jack Ma"),
        Pair("We think, mistakenly, that success is the result of the amount of time we put in at work, instead of the quality of time we put in.",
            "Arianna Huffington"),
        Pair("You don't learn to walk by following the rules. You learn by doing, and falling over.",
            "Richard Branson"),
        Pair("The people who are crazy enough to think they can change the world are the ones who do.",
            "Steve Jobs"),
        Pair("A person should set his goals as early as he can and devote all his energy and talent to getting there. With enough effort, he may achieve it. Or he may find something that is even more rewarding. But in the end, no matter what the outcome, he will know he has been alive.",
            "Walt Disney"),
        Pair("The future rewards those who press on. I don't have time to feel sorry for myself. I don't have time to complain. I'm going to press on.",
            "Barack Obama"),
        Pair("It's harder to stay on top than it is to make the climb. Continue to seek new goals.",
            "Pat Summitt"),
        Pair("If something is important enough, even if the odds are against you, you should still do it.",
            "Elon Musk"),
        Pair("Do the one thing you think you cannot do. Fail at it. Try again. Do better the second time. The only people who never tumble are those who never mount the high wire. This is your moment. Own it.",
            "Oprah Winfrey"),
        Pair("The question I ask myself like almost every day is, 'Am I doing the most important thing I could be doing?",
            "Mark Zuckerberg"),
        Pair("I fear failure, but I won't let it stop me. Sometimes you just got to do it or else it just doesn't happen.",
            "Mark Cuban")

    )
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun HomePageLayout(
        welcome: WelcomePage, n:Int,
        navigateToSettings: () -> Unit,
        modifier: Modifier = Modifier,) {
        val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
        Scaffold(
            modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                InventoryTopAppBar(
                    title = "Hi, " + WelcomePage().getName(),
                    canNavigateBack = false,
                    scrollBehavior = scrollBehavior,
                    navigateSettings = navigateToSettings
                )
            },
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(120.dp))
                Image(
                    painter = painterResource(R.drawable.home_page_img),
                    contentDescription = "home_page_img",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .width(220.dp)
                        .height(240.dp)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = motivation_list.get(n).first,
                    modifier = Modifier.width(270.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    color = Color(104, 136, 180)
                )
                Text(
                    text = motivation_list.get(n).second,
                    modifier = Modifier
                        .width(200.dp)
                        .padding(top = 10.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color(104, 136, 180)

                )
                Spacer(modifier = Modifier.height(70.dp))


            }
        }
    }






